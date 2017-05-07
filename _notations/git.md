---
layout: post
title: "Git"
categories: notation
subtitle: Submodules and Diffing
---

# Misc

`git help -a` | see commands
`git help -p` | concept guides

`git diff` | working to index
`git diff HEAD` | working to HEAD
`git diff --cached` | index to HEAD (cached is a synonym for staged)

```bash
git ls-tree -r --name-only

git add -p # --patch

# submodules
git submodule add git@github.com:cozywigwam/my-submodule.git my-submodule-path
git submodule update --init

git remote add origin [remote repo]

# list merged branches
for branch in `git branch -r --merged | grep -v HEAD`; do echo -e `git show --format="%ci %cr %an" $branch | head -n 1` \\t$branch; done | sort -r

# ...unmerged
for branch in `git branch -r --no-merged | grep -v HEAD`; do echo -e `git show --format="%ci %cr %an" $branch | head -n 1` \\t$branch; done | sort -r
```


# Config

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
