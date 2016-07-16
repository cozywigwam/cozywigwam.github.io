---
layout: post
title: "site-agnostic-mixins"
categories: styles
---

[github)[https://github.com/cozywigwam/site-agnostic-styles/]


Responsive:

```
/* in _site_agnostic_variables.scss */

$small: 460px;
$mobile: 600px;
$laptop: 800px;
$desktop: 1200px;



/* in _site-agnostic_mixins.scss */

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