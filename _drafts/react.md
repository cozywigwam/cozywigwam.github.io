---
layout: post
title: "React"
categories: notation
subtitle: Bye Angular, 'twas fun but don't call me
---

simple SO breakdown of server/client setup options: 
http://stackoverflow.com/questions/27928372/react-router-urls-dont-work-when-refreshing-or-writting-manually/36623117#36623117

use `.js`, not `.jsx`

https://github.com/facebook/react/issues/3582#issuecomment-89411479
FWIW, we've never really advocated using .jsx files. We use .js and most (all?) of our open source projects follow this convention. What people are actually doing… that's may not match. But I think as transpiling JS becomes more and more common-place, it makes sense to just use .js.


Question:
What is the difference between:
  <a onClick={this.handleClickCloseNav}>test</a>
and:
  <a onClick={this.handleClickCloseNav()}>test</a>
and:
  <a onClick={this.handleClickCloseNav().bind(this)}>test</a>
?



- insert whitepsace with {' '} ref: https://facebook.github.io/react/blog/2014/02/20/react-v0.9.html#jsx-whitespace








