---
layout: post
title: "Git"
categories: cheatsheet
subtitle: Submodules and diffing
---

### Submodules

Note lack of trailing slash for the path.

``` bash
git submodule add git@github.com:cozywigwam/my-submodule.git my-submodule-path
git submodule update --init

git remote add origin [remote repo]
```


### Diff

| `git diff` | working to index |
| `git diff HEAD` | everything to HEAD |
| `git diff --cached` | index to HEAD (cached is a synonym for staged) |



### Patching

```bash
git add -p # for --patch
git add -i # for --interactive TODO: learn it
```
