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



### Marks

| `'[mark]` | jump to `[mark]` line |
| `` `[mark]`` | jump to `[mark]` line & col |
| `'[ ']` | begin/end of previous yank/put |
| `'< '>` | " visual selection |
| `'.` | " change |
| `'^` | " insert mode stop |
| `'( ')` | " sentence |
| `'{ '}` | " paragraph |



### Check things out

| `:changes` | changelist |
| `:reg` | registers |
| `q:` | command history |



### Registers

| `""` | unnamed |
| `"a-"z` | named |
| `"0` | yank |
| `+_` | black hole |
| `"* "+` | clipboard |
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

| `:help CTRL-W` | help |
| `CTRL-W =` | equalize |
| `CTRL-W +/-` | adjust height N |
| `CTRL-W </>` | adjust width N |
| `CTRL-W T` | move current window to a new tab page |
| `CTRL-W H/J/K/L` | move current window |
| `CTRL-H/J/K/L` | *[custom map]* move to window |
| `CTRL-W ^` | split with alternate |
| `CTRL-W p` | go to previous (last accessed) window |
| `CTRL-W s/v` | split current window N lines/columns size |
| `CTRL-W W/w` | go to N next/previous window (wrap around) | 



## Plugins & other related

### Navigate NERDTree

| `?` | help |
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

| `<C-b>` | switch to buffer search |
| `<C-f>` | switch to file search |
| `<c-d>` | toggle filename-only (exclude path) |
| `<c-p> <c-n>` | prev/next searches |



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
| `;x` | display element's title \|\| alt text |
