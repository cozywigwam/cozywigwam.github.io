---
layout: post
title: "AS Styles"
categories: styles
---

[styles-root]: `/assets/styles`

### Dependencies

- bootstrap-sass
- compass-breakpoint
- sassy-maps

### Directory tree:

```
.
├── common
├── components
├── layouts
├── pages
└── vendor
    ├── bootstrap-override
    ├── gravity-forms
    └── selectric

9 directories
```

### Setup with Bower & Gulp

#### Bower

```
            
// . . .
            

"dependencies": {
    "compass-breakpoint": "~2.6.1",
    "bootstrap-sass": "3.3.5",
    "fontawesome": "~4.4.0",
              
    // . . .
            
},
"overrides": {
            
    // . . .
            
    "bootstrap-sass": {
        "main": [
            "./assets/stylesheets/bootstrap/_variables.scss",
            "./assets/stylesheets/bootstrap/_mixins.scss",
            "./assets/stylesheets/bootstrap/_normalize.scss",
            "./assets/stylesheets/bootstrap/_print.scss",
            "./assets/stylesheets/bootstrap/_scaffolding.scss",
            "../../assets/styles/vendor/bootstrap-override/*.scss",
            "./assets/stylesheets/bootstrap/_code.scss",
            "./assets/stylesheets/bootstrap/_grid.scss",
            "./assets/stylesheets/bootstrap/_forms.scss",
            "./assets/stylesheets/bootstrap/_buttons.scss",
            "./assets/stylesheets/bootstrap/_component-animations.scss",
            "./assets/stylesheets/bootstrap/_dropdowns.scss",
            "./assets/stylesheets/bootstrap/_button-groups.scss",
            "./assets/stylesheets/bootstrap/_input-groups.scss",
            "./assets/stylesheets/bootstrap/_navs.scss",
            "./assets/stylesheets/bootstrap/_navbar.scss",
            "./assets/stylesheets/bootstrap/_labels.scss",
            "./assets/stylesheets/bootstrap/_badges.scss",
            "./assets/stylesheets/bootstrap/_alerts.scss",
            "./assets/stylesheets/bootstrap/_progress-bars.scss",
            "./assets/stylesheets/bootstrap/_media.scss",
            "./assets/stylesheets/bootstrap/_list-group.scss",
            "./assets/stylesheets/bootstrap/_panels.scss",
            "./assets/stylesheets/bootstrap/_responsive-embed.scss",
            "./assets/stylesheets/bootstrap/_wells.scss",
            "./assets/stylesheets/bootstrap/_close.scss",
            "./assets/stylesheets/bootstrap/_modals.scss",
            "./assets/stylesheets/bootstrap/_tooltip.scss",
            "./assets/stylesheets/bootstrap/_popovers.scss",
            "./assets/stylesheets/bootstrap/_utilities.scss",
            "./assets/stylesheets/bootstrap/_responsive-utilities.scss",
            
            // . . .
            
        ]
    }
}
```

#### Gulp

package.json:

```
    "devDependencies": {
        "asset-builder": "^1.1.0",
        "gulp-autoprefixer": "^3.1.0",
        "gulp-concat": "^2.6.0",
        "gulp-imagemin": "^2.4.0",
        "gulp-less": "^3.0.5",
        "gulp-minify-css": "^1.2.1",
        "gulp-plumber": "^1.0.1",
        "gulp-rev": "^6.0.1",
        "gulp-sass": "^2.1.0",
        "gulp-sourcemaps": "^1.6.0",
        "imagemin-pngcrush": "^4.1.0",
    }

```



gulpfile.js:

```

var plumber = require('gulp-plumber');
var autoprefixer = require('gulp-autoprefixer');
var concat = require('gulp-concat');
var imagemin = require('gulp-imagemin');
var less = require('gulp-less');
var minifyCss = require('gulp-minify-css');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');
var rev = require('gulp-rev');



var manifest = require('asset-builder')('./assets/manifest.json');
var path = manifest.paths;


var cssTasks = function (filename) {
    return lazypipe()
        .pipe(function () {
            return gulpif(!enabled.failStyleTask, plumber());
        })
        .pipe(function () {
            return gulpif(enabled.maps, sourcemaps.init());
        })
        .pipe(function () {
            return gulpif('*.less', less());
        })
        .pipe(function () {
            return gulpif('*.scss', sass({
                outputStyle: 'nested', // libsass doesn't support expanded yet
                precision: 10,
                includePaths: ['.'],
                errLogToConsole: !enabled.failStyleTask
            }));
        })
        .pipe(concat, filename)
        .pipe(autoprefixer, {
            browsers: [
                'last 6 versions',
                'ie 8',
                'ie 9',
                'android 2.3',
                'android 4',
                'opera 12'
            ]
        })
        .pipe(minifyCss, {
            advanced: true,
            rebase: false,
            keepSpecialComments: false
        })
        .pipe(function () {
            return gulpif(enabled.rev, rev());
        })
        .pipe(function () {
            return gulpif(enabled.maps, sourcemaps.write('.', {
                sourceRoot: 'assets/styles/'
            }));
        })();
};


// ### Styles
// `gulp styles` - Compiles, combines, and optimizes Bower CSS and project CSS.
// By default this task will only log a warning if a precompiler error is
// raised. If the `--production` flag is set: this task will fail outright.
gulp.task('styles', ['wiredep'], function () {
    var merged = merge();
    manifest.forEachDependency('css', function (dep) {
        var cssTasksInstance = cssTasks(dep.name);
        if (!enabled.failStyleTask) {
            cssTasksInstance.on('error', function (err) {
                console.error(err.message);
                this.emit('end');
            });
        }
        merged.add(gulp.src(dep.globs, {base: 'styles'})
            .pipe(cssTasksInstance));
    });
    return merged
        .pipe(writeToManifest('styles'));
});

// ### Images
// `gulp images` - Run lossless compression on all the images.
gulp.task('images', function () {
    return gulp.src(globs.images)
        .pipe(imagemin({
            progressive: true,
            interlaced: true,
            svgoPlugins: [{removeUnknownsAndDefaults: false}, {cleanupIDs: false}]
        }))
        .pipe(gulp.dest(path.dist + 'images'))
        .pipe(browserSync.stream());
});



```


### Responsive

Uses Twitter Bootstrap variables (plus 2 custom ones, xl & xxl) with Compass's `@mixin mq`.

- $screen-xs: 480px; 
- $screen-sm: 768px;
- $screen-md: 992px;
- $screen-lg: 1200px;
- $screen-xl: 1400px;
- $screen-xxl: 1600px;

```

// general usage
@include breakpoint(max-width $screen-xs-max) {}
@include breakpoint($screen-sm-min) {}
@include breakpoint($screen-md-min) {}
@include breakpoint($screen-lg-min) {}




/* in bower_components/compass-breakpoint/stylesheets/_breakpoint.scss */
@mixin mq($query, $no-query: false) {
  @include breakpoint($query, $no-query) {
    @content;
  }
}



/* in [styles-root]/common/_variables.scss */

//== Media queries breakpoints
//
//## Define the breakpoints at which your layout will change, adapting to different screen sizes.

// Extra small screen / phone
//** Deprecated `$screen-xs` as of v3.0.1
$screen-xs: 480px;
//** Deprecated `$screen-xs-min` as of v3.2.0
$screen-xs-min: $screen-xs;
//** Deprecated `$screen-phone` as of v3.0.1
$screen-phone: $screen-xs-min;

// Small screen / tablet
//** Deprecated `$screen-sm` as of v3.0.1
$screen-sm: 768px;
$screen-sm-min: $screen-sm;
//** Deprecated `$screen-tablet` as of v3.0.1
$screen-tablet: $screen-sm-min;

// Medium screen / desktop
//** Deprecated `$screen-md` as of v3.0.1
$screen-md: 992px;
$screen-md-min: $screen-md;
//** Deprecated `$screen-desktop` as of v3.0.1
$screen-desktop: $screen-md-min;

// Large screen / wide desktop
//** Deprecated `$screen-lg` as of v3.0.1
$screen-lg: 1200px;
$screen-lg-min: $screen-lg;
//** Deprecated `$screen-lg-desktop` as of v3.0.1
$screen-lg-desktop: $screen-lg-min;

// So media queries don't overlap when required, provide a maximum
$screen-xs-max: ($screen-sm-min - 1);
$screen-sm-max: ($screen-md-min - 1);
$screen-md-max: ($screen-lg-min - 1);



// ...and then custom additions

$screen-xl-min: 1400px; // custom
$screen-xxl-min: 1600px; // custom



```
















### Full directory tree:

```
.
├── __reference
│   ├── _resets-and-normalization.scss
│   ├── _site-agnostic-mixins.scss
│   └── _site_agnostic_variables.scss
├── admin.scss
├── astree.txt
├── astreed.txt
├── common
│   ├── _buttons.scss
│   ├── _global.scss
│   ├── _mixins.scss
│   ├── _nav.scss
│   ├── _slick-variables.scss
│   ├── _tables.scss
│   ├── _type.scss
│   ├── _variables.scss
│   └── _wp-classes.scss
├── components
│   ├── _accordion.scss
│   ├── _carousel.scss
│   ├── _forms.scss
│   ├── _instagram-post.scss
│   ├── _lightbox.scss
│   ├── _modal.scss
│   ├── _newsletter.scss
│   ├── _press-vehicle-gallery.scss
│   ├── _spmp.scss
│   ├── _vc_callout-base.scss
│   ├── _vc_callout-type-1.scss
│   ├── _vc_callout-type-2.scss
│   ├── _vc_callout-type-3.scss
│   ├── _vc_hero.scss
│   ├── _vc_information.scss
│   ├── _vc_ribbon.scss
│   └── _video-carousel.scss
├── layouts
│   ├── _footer.scss
│   ├── _header.scss
│   └── _single.scss
├── main.scss
├── pages
│   ├── _about.scss
│   ├── _buzz.scss
│   ├── _contact-us.scss
│   ├── _events.scss
│   ├── _family-fun.scss
│   ├── _home.scss
│   ├── _members.scss
│   ├── _sponsorship.scss
│   ├── _tickets.scss
│   ├── _timeline.scss
│   ├── _vehicle-gallery-main.scss
│   ├── _vehicle-gallery-single.scss
│   ├── _vehicle-gallery-sort.scss
│   └── _visitor-info.scss
└── vendor
    ├── bootstrap-override
    │   ├── _tables.scss
    │   └── _type.scss
    ├── gravity-forms
    │   ├── _browsers.scss
    │   ├── _formreset.scss
    │   ├── _formsmain.scss
    │   └── _readyclass.scss
    └── selectric
        └── selectric-custom-edited.scss

9 directories, 57 files
```