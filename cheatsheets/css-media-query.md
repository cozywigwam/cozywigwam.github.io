---
layout: post
title: "CSS Media Query"
categories: styles
---

Bootstrap/Compass style, sorta:

```scss

$screen-xs: 480px;
$screen-sm: 768px;
$screen-md: 992px;
$screen-lg: 1200px;
$screen-xl: 1400px;
$screen-xxl: 1600px;

$screen-xs-max: ($screen-sm - 1);
$screen-sm-max: ($screen-md - 1);
$screen-md-max: ($screen-lg - 1);

@mixin breakpoint-custom($breakpoint) {
    @media (min-width: #{$breakpoint}) {
        @content;
    }
}
@mixin breakpoint-max($breakpoint) {
    @media (max-width: #{$breakpoint}) {
        @content;
    }
}
@mixin breakpoint-xs {
    @include breakpoint-custom( ($screen-xs) ) {
        @content;
    }
}
@mixin breakpoint-xs-max {
	@include breakpoint-max($screen-xs - 1) {
		@content;
	}
}
@mixin breakpoint-sm {
    @include breakpoint-custom($screen-sm) {
        @content;
    }
}
@mixin breakpoint-md {
    @include breakpoint-custom($screen-md) {
        @content;
    }
}
@mixin breakpoint-lg {
    @include breakpoint-custom($screen-lg) {
        @content;
    }
}
@mixin breakpoint-xl {
    @include breakpoint-custom($screen-xl) {
        @content;
    }
}
@mixin breakpoint-xxl {
    @include breakpoint-custom($screen-xxl) {
        @content;
    }
}

.mobile-only {
	@include breakpoint-xs {
		display: none !important;
	}
}
.desktop-only {
	@include breakpoint-xs-max {
		display: none !important;
	}
}

```


Alternate, sorta Jekyll style:

```scss

$small: 460px;
$mobile: 600px;
$laptop: 800px;
$desktop: 1200px;

@mixin mq($min) {
	@media screen and (min-width: $min) {
		@content;
	}
}
@mixin mq-max($max) {
	@media screen and (max-width: $max - 1) {
		@content;
	}
}

@include mq-max($mobile) {
}
@include mq($mobile) {
}
@include mq($laptop) {
}
@include mq($desktop) {
}


```