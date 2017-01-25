---
layout: post
title: "Git"
categories: notation
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


### Inspecting

```bash
git ls-tree -r --name-only
```

### Patching

```bash
git add -p # --patch
```



### Config

```
[alias]
	st = status
	co = checkout
	ci = commit
	br = branch
	df = diff
	dfs = diff --staged
    logg = log --date-order --graph --decorate --pretty=format:'%C(yellow)%h %C(cyan)%>(12)%ad %C(magenta)%<(7)%aN%C(auto)%d %Creset%s' --all
    loggg = log --graph --decorate --oneline --abbrev-commit --all
```
