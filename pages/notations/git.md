---
title: "Git"
layout: notation
description: Everything Should Be Git
path: "/git/"
---

# Command Line

## Help

|||
|-|-|
`git help -a` | see commands
`git help -p` | concept guides

## diff differences

|||
|-|-|
`git diff` | working to index
`git diff HEAD` | working to HEAD
`git diff --cached` | index to HEAD (cached is a synonym for staged)

## submodules

```
git submodule add git@github.com:cozywigwam/my-submodule.git my-submodule-path
git submodule update --init
```

```
# list merged branches
for branch in `git branch -r --merged | grep -v HEAD`; do echo -e `git show --format="%ci %cr %an" $branch | head -n 1` \\t$branch; done | sort -r

# ...unmerged
for branch in `git branch -r --no-merged | grep -v HEAD`; do echo -e `git show --format="%ci %cr %an" $branch | head -n 1` \\t$branch; done | sort -r
```

## Logging

via `~/.gitconfig`:

```
[alias]
   logg = log --date-order --graph --decorate --pretty=format:'%C(yellow)%h %C(cyan)%>(12)%ad %C(magenta)%<(7)%aN%C(auto)%d %Creset%s' --all
   loggg = log --graph --decorate --oneline --abbrev-commit --all
```

via `~/.bash_aliases`:

```
# main log format
alias logg="git --no-pager log --date-order --graph --decorate --pretty=format:'%C(green)%h %C(cyan)%>(12)%ad %C(magenta)%<(7)%aN%C(auto)%d%Creset - %s' --all"

# alternate format
alias glog="git log --format='%Cgreen%h%Creset %C(cyan)%an%Creset - %s' --graph"

alias l="logg --no-merges -40" # trunc. at 40 lines
alias lf="logg --no-merges" # full
alias ld="logg --no-merges --date=local -40" # show date
alias lm="logg -30" # with merges

# with merges and full date
alias lmdf="logg --date=local"
alias ldmf="logg --date=local"

```


## Aliases

Common aliases found in `~/.gitconfig`:

```
[alias]
 st = status
 co = checkout
 ci = commit
 br = branch
 df = diff
 dfs = diff --staged
```

My personal aliases in `~/.bash_aliases`:

```
alias a="git add"
alias s="git st"
alias c="git commit"
alias b="git branch"
alias m="git br --merged"
alias co="git co"
alias bd="git co develop"
alias bm="git co master"
alias gp="git pull"
alias gf="git fetch"
alias gc="git clone"
alias l="logg --no-merges -40" # see Logging
```

Note to the reader: if you are using Git at the command line at this level and you're not using Magit, I would encourage you to look into it.

## Misc

|||
|-|-|
`git add -p # --patch` | interactive chunk-adding is your friend
`git ls-tree -r --name-only` | cf. `tree -I node` and `tree -d .`

A shell function to jump to the root of the project:

```
gitroot() {
 gitroot=$(git rev-parse --show-toplevel)
 cd $gitroot
}
```

# Emacs

## Magit

[manual](https://magit.vc/manual/magit.html)

### commands

#### general

|||
|-|-|
| `SPC g s` | `magit-status` | existing or create new |
| `]h`, `[h`  | next/prev hunk            |                                                |
| `SPC g f f` | `magit-find-file`         | open revision                                  |
| `SPC g f h` | `magit-log-buffer-file`   | history/log for current buffer                 |
| `SPC g d w` | `magit-diff-working-tree` | all changes - quickly check if branch is clean |
| `SPC g f c` | `magit-file-checkout` | revert |

#### from status

|||
|-|-|
| `C-u s`                    | [point at untracked file] track without staging ("git add --intent-to-add") |                                                    |
| `M-1`, `M-2`, `M-3`, `M-4` | outline expansion                                                           |                                                    |
| `^`                        | up                                                                          |                                                    |
| `M-w`                      | copy (kill) hash/revision                                                   |                                                    |
| `d`                        | diff options (e.g. whitespace)                                              |                                                    |
| `d s`                      | `magit-diff-staged`                                                         | see everything that would commit                   |
| `E i`                      | `magit-ediff-show-staged`                                                   | ediff a file that has staged changes (`SPC g e s`) |
| `=`                        | split file's hunks into more/smaller hunks                                  |                                                    |
| `+`                        | split file's hunks into fewer/larger hunks                                  |                                                    |
| `0`                        | reset file's hunk qty/size                                                  |                                                    |

#### from log

|||
|-|-|
| `O` | [in log] reset popup |

#### from commit

|||
|-|-|
| `M-p` | [in commit window] pull up previously used commit messages |

#### from popup

|||
|-|-|
| `?`   | describe key    |
| `C-t` | show popup menu |


### add a flag

```emacs-lisp
(magit-define-popup-switch 'magit-log-popup ?m "Omit merge commits" "--no-merges")
```

### reference

[reddit workflows](https://www.reddit.com/r/emacs/comments/2n9tj8/anyone_care_to_share_their_magit_workflow/)

[infix arguements and suffix commands](https://github.com/magit/magit/wiki/Additional-proposed-infix-arguments-and-suffix-commands)

[macOS - use emacs-plus to reduce sluggishness](https://magit.vc/manual/magit/MacOS-Performance.html)


## smerge

|||
|-|-|
| `C-c ^ m` | keep mine  |
| `C-c ^ o` | keep other |


# Vim

## Fugitive

|||
|-|-|
`:Gwrite` | add %
`:Gread` | overwrite working with index
`:Gbrowse` | inspect current object on GitHub

### :Gstatus

|||
|-|-|
`:Gstatus` | status
`g?` | show help
`D` | diff
`U` | checkout file, scrap changes (`:Gread` and `:w`)
`cc` | commit
`cA` | commit `--amend --use-message=HEAD`
`r` | reload
`q` | quit

### :Gdiff

|||
|-|-|
`:[range]diffget [bufspec]` | obtain diff
`:[range]diffput [bufspec]` | put diff
`do` | diff obtain
`dp` | diff put
`:diffget //3` | (from working copy of 3-way merge) obtain from merge branch
`:diffget //2` | same as above but obtain from target branch
`:Gwrite!` | (from target or merge branch) resolve conflicts with this version

### :Gedit

|||
|-|-|
`:Gedit [revision]` | e.g. `:Gedit HEAD^:%`
`<Enter>` | go to object corresponding to SHA on cursor's line
`C` | jump to commit object
`-` | jump to tree object

### [revision]

|||
|-|-|
`:h fugitive-revision` | `HEAD`, `master`, etc.
`HEAD^{}` | commit referenced by HEAD
`-` | current file in HEAD
`^` | current file in previous commit
`~3` | current file 3 commits ago
`:0` | current file in the index
`:2` | (3-way merge) current file in target branch
`:3` | (3-way merge) current file in merge branch
