---
layout: post
title: "Polyambidextrous"
categories: styles
---

Root: `/assets/styles`



Responsive:

- $small: 460px;
- $mobile: 600px;
- $laptop: 800px;
- $desktop: 1200px;

```

/* in _site-agnostic-variables.scss */

$small: 460px;
$mobile: 600px;
$laptop: 800px;
$desktop: 1200px;

@include mq-max($mobile) { }
@include mq($mobile) { }
@include mq($laptop) { }
@include mq($desktop) { }


// Media queries
@mixin media-query($min) {
	@media screen and (min-width: $min) {
		@content;
	}
}
@mixin mq($min) {
	@media screen and (min-width: $min) {
		@content;
	}
}
@mixin media-query-max($max) {
	@media screen and (max-width: $max - 1) {
		@content;
	}
}
@mixin mq-max($max) {
	@media screen and (max-width: $max - 1) {
		@content;
	}
}


```