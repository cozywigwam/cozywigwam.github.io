---
layout: post
title: "Bash"
categories: cheatsheet
subtitle: Well, bash-ish
---

[dotfiles](https://github.com/cozywigwam/dotfiles)


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

```bash
sed -i '.bak' 's/oldterm/newterm/g' [filename] 

# no backup file
sed -i '' 's/oldterm/newterm/g' [filename]

# echo dirs
tree -d .
```
