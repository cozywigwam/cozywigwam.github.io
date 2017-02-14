---
layout: post
title: "tmux"
categories: notation
subtitle: screen+
---

[dotfile](https://github.com/cozywigwam/dotfiles/blob/master/.tmux.conf)


### Key bindings

`list-commands / lscm` | list all commands
`list-keys / lsk / <leader>?` | list all bound keys (default table is "prefix")

Keys are bound to either a key table or a mode table. The two key tables:

- prefix
- root

```bash
tmux list-keys # equivalent to '-T prefix' + '-T root'
```

The mode tables:

- emacs-choice
- emacs-copy
- emacs-edit
- vim-choice
- vim-copy
- vim-edit

```bash
# list prefix & root key bindings
tmux list-keys # equivalent to '-T prefix' + '-T root'

# list vi-copy mode key bindings
tmux lsk -t vi-copy

# vi-copy binding
tmux bind-key -t vi-copy v begin-selection
```


### Options

```bash
# server
tmux show-options -s # tmux show -s
tmux set-option -s # tmux set -s

# session
tmux show -g # -g for global session/window settings
tmux set

# window
tmux showw
tmux setw
```


### Misc

Hold `⌥` when dragging mouse to enable copy to OS X clipboard.

`<leader>z` | zoom
