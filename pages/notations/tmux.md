---
title: "Tmux"
layout: notation
description: Screen+
path: "/tmux/"
---


<a href="https://github.com/cozywigwam/dotfiles/blob/master/.tmux.conf" target="_blank" alt="tmux dotfile">dotfile</a>


# Key bindings

Note: some of this information is outdated as of tmux 2.5. See `man tmux`.

Keys are bound to either a key table or a mode table. Usage `[-t mode-table] [-T key-table]`. The two key tables: 

- `prefix`
- `root`

The mode tables:

- `emacs-choice`
- `emacs-copy`
- `emacs-edit`
- `vim-choice`
- `vim-copy`
- `vim-edit`

|||
|-|-|
`list-commands / lscm` | list all commands
`list-keys / lsk / <leader>?` | list all bound keys (default table is "prefix")


```bash
# list prefix & root key table bindings
tmux list-keys # equivalent to '-T prefix' + '-T root'

# list vi-copy mode table bindings
tmux lsk -t vi-copy

# bind the "v" key in vi-copy mode
tmux bind-key -t vi-copy v begin-selection # old syntax
tmux bind-key -T copy-mode-vi v send -X begin-selection # new syntax

# allow a key to [-r] repeat
bind-key -r L swap-window -t +1

unbind C-n # unbind one thing
unbind-key -a # unbind everything* 
tmux -f /dev/null -L temp start-server \; list-keys # start tmux with default keys
```

\* (see <a href="http://unix.stackexchange.com/questions/57641/reload-of-tmux-config-not-unbinding-keys-bind-key-is-cumulative" target="_blank" alt="stack exchange">Stack Exchange</a>)


# Options

Respectively, see and set:

```bash
# server
tmux show-options -s # tmux show -s
tmux set-option -s # tmux set -s

# session
tmux show -g # -g for global session/window settings
tmux set

# window
tmux showw (alias for `show-window-options`)
tmux setw
```


# Plugins

<a href="https://github.com/tmux-plugins/tpm" target="_blank">Tmux Plugin Manager</a>

Plugins live in `~/.tmux/plugins`. Install with with `[prefix] + I`. Update with `~/.tmux/plugins/tpm/bin/update_plugins all`.


# Misc

Hold `⌥` when click + dragging mouse to enable selection/copying to macOS clipboard.

|||
|-|-|
`[session][:window][.pane]` | target syntax
`<leader>z` | zoom
`<leader>q` | display pane numbers
`<leader>{` & `<leader>}` | swap (move) panes
`attach-session -c ~/new-dir` | change current working-directory
