---
layout: post
title: "Command line"
categories: cheatsheet
subtitle: zsh & misc. CL
---

[dotfiles](https://github.com/cozywigwam/dotfiles)


### zsh

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


### lsof

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


### Ack

[dotfile](https://raw.githubusercontent.com/cozywigwam/dotfiles/master/.ackrc)

```bash
ack --help | less

# ack [options] PATTERN [FILE...]
# ack -f [options] [DIRECTORY...]

ack --dump # see ignores

ack -g ffmpeg /usr/local/ # files that match pattern (`-f` is all files searched)

ack -i --ignore-dir=private --ignore-file="is:test.sql" findme

```


### Jobs

[Linux Signal command library](http://linux.about.com/od/commands/l/blcmdl7_signal.htm)

| `<C-z>` | "suspend" character |
| `<C-y>` | "delayed suspend" character |

```bash
%1 # shorthand for `fg %1`
%1 & # shorthand for `bg %1`
jobs -l # show PID
```


### Misc

`<M-u>` | toggle search highlighting

```bash
# Mac OS
sed -i '.bak' 's/oldterm/newterm/g' [filename] 

# no backup file
sed -i '' 's/oldterm/newterm/g' [filename]

# dir tree
tree -I node
tree -d .

# recent directories
dirs -v

# rename files ./old1.txt, ./old2.txt
rename 's/old/new/g' *

# custom notification sounds for System Prefs -> Sounds
cp my-custom-sound.mp3 ~/Library/Sounds/
```
