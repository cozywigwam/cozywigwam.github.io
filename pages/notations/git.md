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

## get file from SHA/commit

`git checkout 7c9e5d -- file1/to/restore file2/to/restore`

One workflow is to go to the log, open the commit where the file was changed/removed, use `M-w` to kill the hash/SHA, then `git checkout [SHA]~1 -- restore-me.txt`.

## différance

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

Note to the reader: if you are using Git at the command line at this level and you're not using [Magit](https://magit.vc/), I would encourage you to look into it.

## update-index

I have a local global constant that I use for debugging. Loading the videos slows me down, so I want this toggle on pretty much all the time, unless I'm either A) specifically working on videos, or B) working on the site as a whole.

```js
// constants.js

module.exports = {
  SERVER_HOST: process.env.REACT_APP_SERVER_HOST,
  API_VERSION: 'v1',
  DEV_DISABLE_VIDEO: true,
};
```

I don't want `true` to be the setting that a developer would receive when pulling this project down; I want the committed version of the file to be `DEV_DISABLE_VIDEO: false`. However, since I always want it locally to be `true`, it's going to nag all my git statuses with a change in that file.

I can't ignore it, because ignores are whether or not to track a file—not to ignore new changes to a tracked file. But I can use the `update-index` command with `--skip-worktree`:

From `git man update-index`:

>     SKIP-WORKTREE BIT
>         Skip-worktree bit can be defined in one (long) sentence: When reading an entry, if it is marked as skip-worktree, then Git pretends its working directory version is up to date and read the index version
>         instead.
>
>         To elaborate, "reading" means checking for file existence, reading file attributes or file content. The working directory version may be present or absent. If present, its content may match against the index
>         version or not. Writing is not affected by this bit, content safety is still first priority. Note that Git can update working directory file, that is marked skip-worktree, if it is safe to do so (i.e.
>         working directory version matches index version)
>
>         Although this bit looks similar to assume-unchanged bit, its goal is different from assume-unchanged bit's. Skip-worktree also takes precedence over assume-unchanged bit when both are set.

This is where git shines: literal bit-flippin' to solve problems.

```sh
git update-index --skip-worktree constants.js
```

Then when I want to actually add a new constant down the raod, I can use `--no-skip-worktree`.

### Difference between \`skip-worktree\` and \`assume-unchanged\`

From `git man update-index`:

>        --[no-]assume-unchanged
>            When this flag is specified, the object names recorded for the paths are not updated. Instead, this option sets/unsets the "assume unchanged" bit for the paths. When the "assume unchanged" bit is on, the
>            user promises not to change the file and allows Git to assume that the working tree file matches what is recorded in the index. If you want to change the working tree file, you need to unset the bit to
>            tell Git. This is sometimes helpful when working with a big project on a filesystem that has very slow lstat(2) system call (e.g. cifs).
>
>            Git will fail (gracefully) in case it needs to modify this file in the index e.g. when merging in a commit; thus, in case the assumed-untracked file is changed upstream, you will need to handle the
>            situation manually.

From a [blog post](http://fallengamer.livejournal.com/93321.html) found from [Stack Overflow](https://stackoverflow.com/a/13631525/1052412):

> Assume-unchanged assumes that a developer shouldn’t change a file. If a file was changed – than that change is not important. This flag is meant for improving performance for not-changing folders like SDKs. But if the promise is broken and a file is actually changed, git reverts the flag to reflect the reality. Probably it’s ok to have some inconsistent flags in generally not-meant-to-be-changed folders. On the other hand skip-worktree is useful when you instruct git not to touch a specific file ever. That is useful for an already tracked config file. Upstream main repository hosts some production-ready config but you would like to change some settings in the config to be able to do some local testing. And you don’t want to accidentally check the changes in such file to affect the production config. In that case skip-worktree makes perfect scene.

## recover from reset --hard
Not that I would ever need this. Not that anyone would ever need this. But, you know, just in case... to find that missing ref after resetting `--hard` away from an unmerged branch:

```
git reflog [show] # `show` is default
```
## Hooks/Deployment

[Branch targeting](https://github.com/typicode/husky/issues/186):

```sh
branch=$(git rev-parse --symbolic --abbrev-ref $refname)
  if [ "master" == "$branch" ]; then

  # shenanigans

  fi
done
```

[Digital Ocean](https://www.digitalocean.com/community/tutorials/how-to-use-git-hooks-to-automate-development-and-deployment-tasks) hook reference

## Misc

To force push to `master` on GitLab: Settings -> Repository -> Protected Branches

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

|             |                            |                                                |
|-------------|----------------------------|------------------------------------------------|
| `SPC g i`   | [custom] `helm-info-magit` | manual lookup                                  |
| `SPC g s`   | `magit-status`             | existing or create new                         |
| `]h`, `[h`  | next/prev hunk             |                                                |
| `SPC g f f` | `magit-find-file`          | open revision                                  |
| `SPC g f h` | `magit-log-buffer-file`    | history/log for current buffer                 |
| `SPC g d w` | `magit-diff-working-tree`  | all changes - quickly check if branch is clean |
| `SPC g f c` | `magit-file-checkout`      | revert                                         |
| `SPC g e b` | `ediff-buffers`            | diff files                                     |

#### from status

|||
|-|-|
| `C-u s`                    | [point at untracked file] track without staging ("git add --intent-to-add") |                                                    |
| `M-1`, `M-2`, `M-3`, `M-4` | outline expansion                                                           |                                                    |
| `^`                        | up                                                                          |                                                    |
| `M-w`                      | copy (kill) hash/revision/commit/SHA                                        |                                                    |
| `d`                        | diff options (e.g. whitespace)                                              |                                                    |
| `d s`                      | `magit-diff-staged`                                                         | see everything that would commit                   |
| `E i`                      | `magit-ediff-show-staged`                                                   | ediff a file that has staged changes (`SPC g e s`) |
| `=`                        | split file's hunks into more/smaller hunks                                  |                                                    |
| `+`                        | split file's hunks into fewer/larger hunks                                  |                                                    |
| `0`                        | reset file's hunk qty/size                                                  |                                                    |

#### from log

|             |                                         |                               |
|-------------|-----------------------------------------|-------------------------------|
| `O`         | [in log] `magit-reset-popup`            | reset popup                   |
| `L l` | [in log] (custom) `magit-toggle-margin` | toggle name & date side panel |

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

### refs

[manual](https://magit.vc/manual/magit/References-Buffer.html)

`y` is evilified, so use `C-- y` for `magit-show-refs-popup`. `@` indicates current comparison point, which is also HEAD. `#` indicates current comparison point that is not HEAD.

In status, `C-- y r` for `magit-show-refs-popup`, `? y` for `magit-show-refs`. Custom keybindings:

|||
|-|-|
| `SPC g m y` | `magit-show-refs-popup`   |
| `SPC g y y` | `magit-show-refs-head`    |
| `SPC g y c` | `magit-show-refs-current` |
| `SPC g y o` | `magit-show-refs`         |

Use `L` for `magit-margin-popup`.

### reference

[reddit workflows](https://www.reddit.com/r/emacs/comments/2n9tj8/anyone_care_to_share_their_magit_workflow/)

[infix arguements and suffix commands](https://github.com/magit/magit/wiki/Additional-proposed-infix-arguments-and-suffix-commands)

[macOS - use emacs-plus to reduce sluggishness](https://magit.vc/manual/magit/MacOS-Performance.html)


## smerge

Compare ediff/emerge.

|           |                        |
|-----------|------------------------|
| `<ret>`     | [on `unmerged`] smerge |
| `C-c ^ m` | keep mine              |
| `C-c ^ o` | keep other             |
| `C-c ^ n` | next                   |

## Version-Control layer

(Spacemacs)

|             |                            |                                                |
|-------------|----------------------------|------------------------------------------------|
| `]h`, `[h`  | next/prev hunk             |                                                |

From `.emacs.d/layers/+source-control/version-control/README.org`:

| Key Binding | Description                     |
|-------------|---------------------------------|
| `SPC g .`   | version control transient-state |
| `SPC T d`   | toggle diff margins             |
| `SPC T C-d` | toggle diff margins globally    |

### Version Control Transient-state

| Key Binding | Description                  |
|-------------|------------------------------|
| `SPC g . h` | Show diff of hunk            |
| `SPC g . n` | Next hunk                    |
| `SPC g . N` | Previous hunk                |
| `SPC g . p` | Previous hunk                |
| `SPC g . r` | Revert hunk                  |
| `SPC g . s` | Stage hunk                   |
| `SPC g . t` | Toggle margin indicators     |
| `SPC g . w` | Stage file                   |
| `SPC g . u` | Unstage file                 |
| `SPC g . d` | Repo diff popup              |
| `SPC g . D` | Show diffs of unstaged hunks |
| `SPC g . c` | Commit with popup            |
| `SPC g . C` | Commit                       |
| `SPC g . P` | Push repo with popup         |
| `SPC g . f` | Fetch for repo with popup    |
| `SPC g . F` | Pull repo with popup         |
| `SPC g . l` | Show repo log                |

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
