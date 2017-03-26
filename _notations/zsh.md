---
layout: post
title: "zsh"
categories: notation
subtitle: Commandments
---

[dotfile](https://github.com/cozywigwam/dotfiles/blob/master/.zshrc)

### ZLE

[Reference](http://sgeb.io/posts/2014/04/zsh-zle-custom-widgets/) from Serge Gebhardt's site.

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

`<M-x>` | emacs & [mapped] viins: execute `execute-named-cmd`
`:` | vicmd: execute `execute-named-cmd`
