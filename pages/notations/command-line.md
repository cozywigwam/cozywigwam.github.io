---
title: "Command Line"
layout: notation
description: Shell, Term, Nix
path: "/command-line/"
---

# Builtins and Commands

## ack

<a href="https://raw.githubusercontent.com/cozywigwam/dotfiles/master/.ackrc" target="_blank" alt="ackrc">dotfile</a>

```bash
ack --help | less

# ack [options] PATTERN [FILE...]
# ack -f [options] [DIRECTORY...]

ack --dump # see ignores

ack -g ffmpeg /usr/local/ # files that match pattern (`-f` is all files searched)

ack -i --ignore-dir=private --ignore-file="is:test.sql" findme
```


## jobs

[Linux Signal command library](http://linux.about.com/od/commands/l/blcmdl7_signal.htm)

|||
|-|-|
| `<C-z>` | "suspend" character |
| `<C-y>` | "delayed suspend" character |

```bash
%1 # shorthand for `fg %1`
%1 & # shorthand for `bg %1`
jobs -l # show PID
```


## less

|||
|-|-|
| `M-u` | toggle search highlighting (like `:noh`) |


## lsof

```bash
lsof -h

lsof /dir/or/file

# `-i [i]`: internet address matches [i]; default all
lsof -i 
lsof -i | grep -Ei "(LISTEN|EXTENDED)"
lsof -i :3000
lsof -t -i :3000 # PID only

lsof -c node # command
lsof -u charadriidae # user

kill -9 `lsof -t -u charadriidae`
```


## Misc

```bash
# dir tree
tree -I node
tree -d .

# recent directories
dirs -v

# rename files ./old1.txt, ./old2.txt
rename 's/old/new/g' *

ytdl --extract-audio --audio-format mp3 <url>
```

### macOS

```sh
# sed requires `-i`
sed -i '.bak' 's/oldterm/newterm/g' [filename] 
sed -i '' 's/oldterm/newterm/g' [filename] # no backup file

# custom notification sounds for System Prefs -> Sounds
cp my-custom-sound.mp3 ~/Library/Sounds/
```


# shells

## zsh

<a href="https://github.com/cozywigwam/dotfiles/blob/master/.zshrc" target="_blank" alt="zsh dotfile">dotfile</a>

```bash
man zsh
man zshbuiltins
man zshoptions

# prompt, jobs, if/then
man zshmisc

# show (default non-vicmd/viins) zle key bindings
bindkeys

# setopt HIST_IGNORE_SPACE
```


### ZLE

<a href="http://sgeb.io/posts/2014/04/zsh-zle-custom-widgets/" target="_blank" alt="reference">Reference</a> from Serge Gebhardt's site.

```bash
man zsh
man zshbuiltins
man zshoptions

# prompt, jobs, if/then
man zshmisc

zle -la # list widgets (aka commands)

bindkey # show (default non-vicmd/viins) zle key bindings
bindkey -M viins # just viins mode
bindkey -M emacs '\e.' # just the <M-.> binding in emacs mode
bindkey -rM emacs '\e.' # `-r` to remove binding

# ref. http://www.zsh.org/mla/users/2009/msg00875.html
bindkey -rM vicmd -- '-' # use `--` since `-` expects an option

echo $fpath # zsh's function path
```

Use `\e` or `^[` to indicate Meta key.

Modes: `viins`, `vicmd`, `emacs`, others.

|||
|-|-|
`<M-x>` | emacs & [mapped] viins: execute `execute-named-cmd`
`:` | vicmd: execute `execute-named-cmd`



## emacs

### term

|||
|-|-|
| `C-c C-j` | switch to line mode |
| `C-c C-k` | switch to char mode |

### eshell

|                      |                                                               |
|----------------------|---------------------------------------------------------------|
| `C-p`, `C-n`         | previous/next input [custom]                                  |
| `M-p`, `M-n`         | previous/next match                                           |
| `C-c C-p`, `C-c C-n` | previous/next prompt                                          |
| `C-u 0 C-l`          | recenter prompt to top with zero arg to `recenter-top-bottom` |
| `C-u`                | [insert mode] universal-argument                              |
| `f1 k`               | [insert mode] `describe-key`                                  |
| `SPC b C-r`          | `rename-buffer`                                               |

#### alias

```sh
alias customls 'ls -la $*'
which customls
```

#### reference

Mickey Peterson's <a href="https://www.masteringemacs.org/article/complete-guide-mastering-eshell" target="_blank">Mastering Eshell</a>

### man/woman

|||
|-|-|
| `(customize-group 'man)` |
