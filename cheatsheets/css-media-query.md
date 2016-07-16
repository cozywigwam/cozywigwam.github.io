---
layout: post
title: "CSS Media Query"
categories: styles
---


```css

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