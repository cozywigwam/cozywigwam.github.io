---
title: "CSS"
layout: notation
description: The Weird Kid at the Party
path: "/css/"
---


# General
## Reference

[CSS spec](https://www.w3.org/Style/CSS/specs.en.html)


## Custom Properties
### Spec

[W3](https://www.w3.org/TR/css-variables/)


### Syntax Examples

There are regular variables...:

```css
:root {
  --site-red: #f00;
}
h1 {
  var(--site-red);
}
```

...and mixin-esque custom properties:

```css
:root {
  --an-argumentless-mixin: {
    color: red;
    border: 1px solid pink;
  }
}
.an-unargumentative-element {
  @apply --an-argumentless-mixin;
}
```

These mixins might require the `Experimental Web Platform features` flag in Chrome, found here: `chrome://flags/#enable-experimental-web-platform-features`.

Here are both:

```css
:root {
  --my-var: red;
  --my-mixin: {
    color: var(--my-var);
    background: #ccc;
  }
}
.lucky-element {
  color: var(--my-var);
}
.extra-lucky-element {
  @apply --my-mixin;
}
```

Note that you cannot overwrite a root variable used by a mixin:

```css
:root {
  --not-overwritten-var: 1px;
  --mixin: {
    width: var(--not-overwritten-var);
  }
}
.test-element {
  /* you can't do this */
  --not-overwritten-var: 10px;

  /* this mixin gets 1px, not 10px */
  @apply --mixin;
}
```

### Reference

Customization examples from a [GitHub issue](https://github.com/syl20bnr/spacemacs/issues/6649).

Serg Hespodarets' [custom props in depth](https://blog.hospodarets.com/css_properties_in_depth), [native CSS mixins](https://blog.hospodarets.com/css_apply_rule), and on [Smashing Magazine](https://www.smashingmagazine.com/2017/04/start-using-css-custom-properties/).

## Nesting


### Descendent

Use `&` to refer to parent block:

```css
div {
  & > span {
    /* direct descendant */
    background: #eee;
  }
  & span {
    /* all within div */
    background: #bbb;
  }
  & ul {
    & span {
      /* this block's `&` refers to `ul`, not `div` */
      background: #999;
    }
  }
}
```


### Ascendent

```css
.deep-element {
  color: black;

  /* note both `@nest` and `&` */
  @nest body.is-state & {
    color: red;
  }
}
```


## Media Queries


### Top Level

```css
@media (min-width: 480px) {
  .box {
    padding: 20px;
  }
}

@custom-media --xs-max (max-width: 479px);
@media (--xs-max) {}
@custom-media --sm (min-width: 480px);
@media (--sm) {}
@custom-media --sm-max (max-width: 767px);
@media (--sm-max) {}
@custom-media --md (min-width: 768px);
@media (--md) {}
@custom-media --md-max (max-width: 991px);
@media (--md-max) {}
@custom-media --lg (min-width: 992px);
@media (--lg) {}
@custom-media --xl (min-width: 1200px);
@media (--xl) {}
@custom-media --xxl (min-width: 1600px);
@media (--xxl) {}

@media (width >= 500px) and (width <= 1200px) {}

@custom-media --only-medium-screen (width >= 500px) and (width <= 1200px);
@media (--only-medium-screen) {}
```


# Transforms

Re SVG, it's their oject bounding box that gets transformed.

# CSS Modules

[GitHub](https://github.com/css-modules/css-modules)
[Interoperable CSS (ICSS)](https://github.com/css-modules/icss)


## Glen Maddern's intro

[Glen Maddern's introduction](https://glenmaddern.com/articles/css-modules)

Each class gets all the styles it needs...

```css
/* components/submit-button.css */
.normal { /* all styles for Normal */ }
.disabled { /* all styles for Disabled */ }
.error { /* all styles for Error */ }
.inProgress { /* all styles for In Progress */ }
```

...by composing:

```css
.common {
  /* all the common styles you want */
}
.normal {
  composes: common;
  /* anything that only applies to Normal */
}
.disabled {
  composes: common;
  /* anything that only applies to Disabled */
}
.error {
  composes: common;
  /* anything that only applies to Error */
}
.inProgress {
  composes: common;
  /* anything that only applies to In Progress */
}
```


### Compose between files

```css
/* colors.css */
.primary {
  color: #720;
}
.secondary {
  color: #777;
}
/* other helper classes... */
```

### More examples

```css
.element {
  composes: large from "./typography.css";
  composes: dark-text from "./colors.css";
  composes: padding-all-medium from "./layout.css";
  composes: subtle-shadow from "./effect.css";
}

/* this short hand: */
.element {
  composes: padding-large margin-small from "./layout.css";
}

/* is equivalent to: */
.element {
  composes: padding-large from "./layout.css";
  composes: margin-small from "./layout.css";
}

/* more examples ... */
.article {
  composes: flex vertical centered from "./layout.css";
}

.masthead {
  composes: serif bold 48pt centered from "./typography.css";
  composes: paragraph-margin-below from "./layout.css";
}

.body {
  composes: max720 paragraph-margin-below from "layout.css";
  composes: sans light paragraph-line-height from "./typography.css";
}
```


# postcss


## cssnext


### Phenomic setup

Directory setup (with the global styles file renamed and moved to `styles/`):

```shell
.
├── content
│   ├── assets
│   │   └── portfolio
│   ├── pages
│   └── ...
├── dist
├── scripts
└── src
    ├── components
    │   └── ...
    ├── layouts
    │   └── ...
    └── styles

./
package.json
postcss.config.js
variables.js
webpack.config.js

./src/styles/
headings.css
highlight.css
mixins.css
phenomic-base.css
reset.css
styles.global.css

/* styles.global.css */
@import './reset.css';
@import './phenomic-base.css';

@import './mixins.css';
@import './headings.css';
@import './highlight.css';
```

In order to import these CSS files, add `require('postcss-import')(),` to `postcss.config.js`:

```js
// postcss.config.js
const vars = require('./variables.js');

module.exports = (config) => [
    require("stylelint")(),
    require('postcss-import')(),
    require("postcss-cssnext")({
      // ref: http://cssnext.io/usage/
      browsers: "last 2 versions",
      features: {
        customProperties: {
          variables: vars,
        },
      },
    }),
    require("postcss-reporter")(),
    ...!config.production ? [
      require("postcss-browser-reporter")(),
    ] : [],
  ]
```

Also note the external `variables.js` file:

```js
// variables.js
module.exports = {
  myVar: 'orange',
}
```

### Reference

- [cssnext home](http://cssnext.io/)
- [Rico St. Cruz's cheatsheet](http://ricostacruz.com/cheatsheets/cssnext.html)


## browserlist

[Chris Coyier's write-up](https://css-tricks.com/browserlist-good-idea/)


# Styled Components


## Example directly to a Styled Component

    
```js
// /App.js
import { OrangeSpan } from './styled/Button.js'
// ...
<div>
  <OrangeSpan/>
</div>

// /styled/Button.js
import React from 'react'
import styled from 'styled-components';

export const OrangeSpan = styled.span`
  background: orange;
`
```


## Example to an intermediate component inside styled/comp.js

    
```js
// /App.js
import { Button } from './styled/Button.js'
// ...
<div>
  <Button/>
</div>


// /styled/Button.js
import React from 'react'
import styled from 'styled-components';

const ButtonThatMovesPerOpen = styled.div`
  position: absolute;
  margin-left: ${(props) => (props.open) ? `${props.width}px` : 'none'};
  transition: margin .2s;
`
export const Button = (props) => {
  return (
    <ButtonThatMovesPerOpen {...props}>
      <span onClick={props.toggle}>button</span>
    </ButtonThatMovesPerOpen>
  )
}
```


# Misc


## Styles in HTML <head>

CSS Styles in the head [MDN](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/style)

```html
<link href="styles/main.css" rel="stylesheet">

<style>
    body { display: none; }
</style>

<!-- optional [MIME] `type` attribute defauts to `text/css`, i.e. <style type="text/css" /> -->
```


## Paragraph line width in em

Proper main-content line lengths, in em, [ref](http://maxdesign.com.au/articles/ideal-line-length-in-ems/):

> As you can see, the average seems to suggest that your container width should be set between the narrowest width of 21em (approx 49 characters per line) to the widest width of 30em (approx 71 characters per line).


## blockquote

```html
<figure class="quote">
	<blockquote><p>...the author hopes to be held guiltless by those to whom the work is addressed—enlightened souls who prefer dry wines to sweet, sense to sentiment, wit to humor and clean English to slang.</p></blockquote>
	<figcaption>Ambrose Bierce, <cite>The Devil's Dictionary</cite></figcaption>
</figure>
```

## clearfix

```html
.clearfix:after {
  content: "";
  display: table;
  clear: both;
}
```

## text selection

`::selection { ... }`

