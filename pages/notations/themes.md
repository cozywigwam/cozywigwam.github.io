---
title: "Themes"
layout: notation
description: Haphazard but Serviceable
path: "/themes/"
---

# Vim

<a href="https://github.com/cozywigwam/poly" target="_blank" alt="Poly Vim theme">Poly</a> is a deviation from Chris Kempson's <a href="https://github.com/chriskempson/tomorrow-theme" target="_blank">tomorrow-night-eighties</a>.

![Poly Theme](/assets/poly-03.jpg) 

![Poly Theme](/assets/poly-02.jpg) 

It works on macOS in terminal/tmux. See <a href="https://github.com/cozywigwam/poly" target="_blank">github</a> for TrueColor and `termguicolors` considerations. The following will tame tmux:

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

To make the <a href="https://github.com/vim-airline/vim-airline" target="_blank">airline</a> styles match, I created a <a href="https://gist.github.com/cozywigwam/e6e0572c6d6529df3eceaaba205c87ac" target="_blank">poly-coordinated variation</a> (derived from <a href="https://github.com/vim-airline/vim-airline-themes/blob/master/autoload/airline/themes/bubblegum.vim" target="_blank">bubblegum</a>). It goes in `~/.vim/autoload/airline/themes`.


# Emacs

As a warning, this theme is hacky. It is built on top of <a href="https://github.com/purcell/color-theme-sanityinc-tomorrow" target="_blank">sanityinc-tomorrow-eighties</a> (which is great), and it doesn't follow best practices.

![Unknotted Theme](/assets/unknotted-01.jpg) 

With that being said, though, it is a functioning and extended port of Poly. It includes dired, man, magit, helm, eshell, org, grep/ag, and front-end modes. <a href="https://github.com/cozywigwam/dotfiles/blob/a0756c791feda2950d1a616072aef0203f9abbd2/.spacemacs#L430-L809" target="_blank">Link</a>

![Unknotted Theme](/assets/unknotted-03.jpg) 


# iTerm

I use a <a href="https://gist.github.com/cozywigwam/8cf85615375699ede084b500cd410b93" target="_blank">base16 eighties</a> theme with the background slightly modified (<a href="https://github.com/chriskempson/base16-iterm2" target="_blank">original</a>).


