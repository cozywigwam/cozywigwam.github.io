---
title: "Themes"
layout: notation
description: Haphazard but Serviceable
path: "/themes/"
---

# Vim

[Poly](https://github.com/cozywigwam/poly) is a deviation from Chris Kempson's [tomorrow-night-eighties](https://github.com/chriskempson/tomorrow-theme).

![Poly Theme](/assets/poly-03.jpg) 

![Poly Theme](/assets/poly-02.jpg) 

It works on macOS in terminal/tmux. See [github](https://github.com/cozywigwam/poly) for TrueColor and `termguicolors` considerations. The following will tame tmux:

```
# ~/.tmux.conf

set -g status-bg '#202020'
set -g status-fg '#555555'
set -g window-status-bg default
set -g window-status-fg default
set -g window-status-current-bg '#202020'
set -g window-status-current-fg '#ff8c94'
set -g pane-border-style fg='#000000'
set -g pane-active-border-style fg='#000000'
```

To make the [airline](https://github.com/vim-airline/vim-airline) styles match, I created a [poly-coordinated variation](https://gist.github.com/cozywigwam/e6e0572c6d6529df3eceaaba205c87ac) (derived from [bubblegum](https://github.com/vim-airline/vim-airline-themes/blob/master/autoload/airline/themes/bubblegum.vim)). It goes in `~/.vim/autoload/airline/themes`.


# Emacs

As a warning, this theme is hacky. It is built on top of [sanityinc-tomorrow-eighties](https://github.com/purcell/color-theme-sanityinc-tomorrow) (which is great), and it doesn't follow best practices.

![Unknotted Theme](/assets/unknotted-01.jpg) 

With that being said, though, it is a functioning and extended port of Poly. It includes dired, man, magit, helm, eshell, org, grep/ag, and front-end modes. [Link](https://github.com/cozywigwam/dotfiles/blob/a0756c791feda2950d1a616072aef0203f9abbd2/.spacemacs#L430-L809)

![Unknotted Theme](/assets/unknotted-03.jpg) 


# iTerm

I use a [base16 eighties](https://gist.github.com/cozywigwam/8cf85615375699ede084b500cd410b93) theme with the background slightly modified ([original](https://github.com/chriskempson/base16-iterm2)).


