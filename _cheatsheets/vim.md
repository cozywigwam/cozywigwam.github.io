---
layout: post
title: "VIM"
categories: cheatsheet
subtitle: Seek nirvana
---

[dotfile](https://github.com/cozywigwam/dotfiles/blob/master/.vimrc)



### Misc

| `<C-v><C-i>` | insert a tab character |
| `<C-v>[unicode]` | insert unicode |
| `\l` | *[custom map]* toggle tab/spaces visibility |
| `ga` | examine character at cursor |
| `\p` | *[custom map]* reveal syntax group for highlighting | 
| `:help cmdline-special` | notes about % and # |
| `:noh` | stop highlighting searches |
| `\h` | *[custom map]* stop highlighting searches |
| `\o` | *[custom map]* `:source ~/.vimrc` |
| `<C-r>[register]` | (from input mode) insert contents of register |
| `//e` | repeat search and move cursor to end of highlight |
| `:h text-objects` | word, sentence, paragraph, tag, b/), B/}, ], etc. |
| `:h filename-modifiers` | `%`, `%:p`, etc. |
| `%` | current filename with relative path |
| `%:p` | current filename with full path |
| `%:p:h` | full path only |
| `\k` | *[custom map]* new line above: `O<Esc>` |
| `\j` | *[custom map]* new line below: `o<Esc>` |


### Marks

| `` `[mark]`` | jump to `[mark]` line & col |
| `'[mark]` | jump to `[mark]` line |
| `` `[ `]`` | begin/end of previous yank/put |
| `` `< `>`` | " visual selection |
| `` `.`` | " last change (like the first `g;` |
| `` `^`` | " last insert mode exit (used by `gi`) |
| `` `( `)`` | " sentence |
| `` `{ `}`` | " paragraph |



### Lists

| `:ju[mps]` | jumplist |
| `:changes` | change list |
| `:reg` | registers |
| `:ar[gs]` | argument list |
| `:cope[n]` | quickfix list |



### Command-Line mode

Command-Line mode "exposes us to the vestiges of ex." (Drew Neil) 

Start with `:` and use `<C-p>` and `<C-n>` to navigate and edit history. Use `<C-f>` to open command-line history (cf. `q:`).

| `q:` | command-line history |
| `@:` `@@` | repeat last command-line command (TODO: `@@` difference?) |



### Registers

| `""` | unnamed |
| `"a-"z` | named |
| `"0` | yank |
| `+_` | black hole |
| `"+` | clipboard |
| `"*` | primary (or redundant clipboard in Mac OS X) |
| `"=` | expression |
| `"% "# ". ": "/` | *read-only registers* |



### Tabs & spaces

| `\l` | Toggle tab/spaces visibility |
| `tabstop (ts)` | How many columns a tab equals |
| `softtabstop (sts)` | How many columns you get for inserting a tab |
| `shiftwidth` | How many columns `<<` and `>>` get |
| `expandtab/noexpandtab (et)` | Expand tabs to become spaces |
| `retab` | Replace white-space with settings |

To convert the full document's tabs to spaces, `:set expandtab` and then `:retab!` (`!` includes "strings of only normal spaces" in the conversion).



### Windows

| `:help ctrl-w` | help |
| `<C-w> =` | equalize |
| `<C-w> +/-` | adjust height N |
| `<C-w> </>` | adjust width N |
| `<C-w> ^` | split with alternate |
| `<C-w> p` | go to previous (last accessed) window |
| `<C-w> s/v` | split current window N lines/columns size |
| `<C-w> W/w` | go to N next/previous window (wrap around) | 
| `<C-w> _` | "maximize" vertically |
| `<C-w> |` | "maximize" horizontally |
| `<C-w> H/J/K/L` | move window |
| `<C-w> x` | exchange with neighbor |
| `<C-w> r` | rotate |
| `<C-w> T` | move current window to a new tab page |



## Plugins & other related

### NERDTree

| `?` | help |
| `F2` | *[custom map]* open NERDTree (default width) |
| `F3` | *[custom map]* toggle open/close |
| `C` | TREEROOT NAVIGATION - down |
| `U` | TREEROOT NAVIGATION - up |
| `u` | TREEROOT NAVIGATION - collapse tree & up |
| `CD`| TREEROOT NAVIGATION - go to pwd |
| `cd`| update pwd |
| `P` | jump to tree root |
| `p` | jump to parent |
| `O` | expand all sub-dirs |
| `X` | collapse all sub-dirs |
| `I` | toggle hidden |
| `R` | refresh |



### Ctrl-P

| `?<CR>` | open help |
| `<C-b> <C-f>` | cycle between modes |
| `<C-d>` | toggle between full-path & filename only search |
| `<C-p> <C-n>` | prev/next searches |



### Vimperator

| `:hs! [filter]` | history; use the bang to immediately open results |
| `o O` | open / open with current address populated |
| `t T` | new tab / new tab with " |
| `w W` | new window / new window with " |
| `p P` | open with clipboard (URL or search) / new tab with clipboard |
| `;` | extendended hint |
| `;;` | focus |
| `;S` | save object |
| `;y` | yank location |
| `;#` | yank anchor URL |
| `;v` | view source |
| `;V` | open source in editor |
| `;c` | open context menu |
| `;I` | open media object in new tab |
| `m` | create mark |
| `M` | create quickmark |
| `:marks` | see marks |
| `:qmarks` | see quick marks |


### Fugitive

`:Gwrite` | add %
`:Gread` | overwrite working with index
`:Gbrowse` | inspect current object on github.com

#### :Gstatus

`:Gstatus` | status
`g?` | show help
`D` | diff
`cc` | commit
`cA` | commit `--amend --use-message=HEAD`
`r` | reload
`q` | quit

#### :Gdiff

`:[range]diffget [bufspec]` | obtain diff
`:[range]diffput [bufspec]` | put diff
`do` | diff obtain
`dp` | diff put
`:diffget //3` | (from working copy of 3-way merge) obtain from merge branch
`:diffget //2` | same as above but obtain from target branch
`:Gwrite!` | (from target or merge branch) resolve conflicts with this version

#### :Gedit

`:Gedit [revision]` | e.g. `:Gedit HEAD^:%`
`<Enter>` | go to object corresponding to SHA on cursor's line
`C` | jump to commit object
`-` | jump to tree object

#### [revision]

`:h fugitive-revision` | `HEAD`, `master`, etc.
`HEAD^{}` | commit referenced by HEAD
`-` | current file in HEAD
`^` | current file in previous commit
`~3` | current file 3 commits ago
`:0` | current file in the index
`:2` | (3-way merge) current file in target branch
`:3` | (3-way merge) current file in merge branch


