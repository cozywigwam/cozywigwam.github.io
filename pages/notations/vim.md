---
title: "Vim"
layout: notation
description: Seek Nirvana
path: "/vim/"
---

[dotfile](https://github.com/cozywigwam/dotfiles/blob/master/.vimrc)

# Application

## Misc

| | |
| - |  - |
`~` | swap case
`:ver` | know thyself
`!echo $VIMRUNTIME` | you are here
`<C-v><C-i>` | insert a tab character
`<C-v>[unicode]` | insert unicode
`ga` | examine character at cursor
`<leader>H` | [custom map] reveal syntax group for highlighting 
`:help cmdline-special` | notes about % and #
`:noh` (`<leader>n` custom) | stop highlighting searches
`<C-r>[register]` | (from input mode) insert contents of register
`:h text-objects` | word, sentence, paragraph, tag, b/), B/}, ], etc.
`:h filename-modifiers` | `%`, `%:p`, etc.
`%` | current filename with relative path
`%:p` | current filename with full path
`%:p:h` | full path only
`gx` | open URL under cursor
`<leader>fmap` | [custom] list all <leader> mappings


## Search

|||
|-|-|
`:h /magic` | literalism and escapism
`:h pattern-overview` | atoms, character classes, etc.
`//e` | repeat search and move cursor to end of highlight (character "offsets")
`:%sno/<div>/<span/` | "nomagic" substitution
`\C` | respect case (can go anywhere in pattern)
`:set nowrapscan` | prevent jump between bottom/top when searching
`{-}` | be ungreedy
`<`, `>` | word boundaries

Delete unwanted lines:

||
|-|
| `:g/^$/d` |
| `:v/./d` |
| `:g/^\s*$/d` |
| `:v/\S/d` |

|||
|-|-|
`:h pattern-atoms` |
`:h whitespace` |
`\d` | digit [0-9]
`\D` | non-digit [^0-9]
`\s` | white space [ ] (<Tab> and <Space>)
`\_s` | white space with newline
`\S` | non-white characters [^ ] (not <Tab> and <Space>)
`\l` | lowercase alpha [a-z]
`\L` | non-lowercase alpha [^a-z]
`\u` | uppercase alpha [A-Z]
`\U` | non-uppercase alpha [^A-Z]
`\w` | word character [0-9a-fA-F_]
`\W` | non-word character [^0-9a-fA-F_]
`\_x` | "x" is any character class character but with newline
`\t` | <tab>
`\r` | <cr>, good for substitution
`\n` | end-of-line, good for search
`~` | last substitution string
`\1`, `\2`... | parenthetical sub-expression/submatch
`\zs`, `ze` | set start/end of match

## Marks

|||
|-|-|
`` `[mark]`` | jump to `[mark]` line & col
`'[mark]` | jump to `[mark]` line
`` `[ `]`` | begin/end of previous yank/put
`` `< `>`` | " visual selection
`` `.`` | " last change (like the first `g;`)
`` `^`` | " last insert mode exit (used by `gi`)
`` `( `)`` | " sentence
`` `{ `}`` | " paragraph



## Lists

|||
|-|-|
`:ju[mps]` | jumplist
`:changes` | change list
`:reg` | registers
`:ar[gs]` | argument list
`:cope[n]` | quickfix list

### Quickfix list

|||
|-|-|
`]q` & `[q` | up/down
`]Q` & `[Q` | last/first
`]]q` & `[[q` | next/prev file
`]]Q` & `[[Q` | next/prev quickfix list


## Command-Line mode

> Command-Line mode "exposes us to the vestiges of ex." -Drew Neil 

Start with `:` and use `<C-p>` and `<C-n>` to navigate and edit history. Use `<C-f>` to open command-line history (cf. `q:`).

|||
|-|-|
`q:` | command-line history
`@:` `@@` | repeat last command-line command (TODO: `@@` difference?)



## Registers

|||
|-|-|
`:h registers` | naturally
`0` | yank & delete
`1` | delete with `%`, `(`, `)`, `/`, `?`, `n`, `N`, `{`, `}`
`-` | small delete (< 1 line)
`+` | clipboard
`*` | primary (or redundant clipboard in macOS)
`=` | expression
`_` | black hole
`%` `#` | filename, alt filename
`/` | last search pattern


## Tabs & spaces

|||
|-|-|
`<leader>t?` | `:set ts? sts? sw?`
`<leader>t2` | `:set ts=2 sts=2 sw=2`
`<leader>t4` | `:set ts=4 sts=4 sw=4`
`tabstop (ts)` | How many columns a tab equals
`softtabstop (sts)` | How many columns you get for inserting a tab
`shiftwidth (sw)` | # when shifting with angle brackets
`expandtab/noexpandtab (et)` | Expand tabs to become spaces
`retab` | Replace white-space with settings

To convert the full document's tabs to spaces, `:set expandtab` and then `:retab!` (`!` includes "strings of only normal spaces" in the conversion).



## Windows

|||
|-|-|
`:help ctrl-w` | help
`<C-w> =` | equalize
`<C-w> +/-` | adjust height N
`<C-w> </>` | adjust width N
`<C-w> ^` | split with alternate
`<C-w> p` | go to previous (last accessed) window
`<C-w> s/v` | split current window N lines/columns size
`<C-w> W/w` | go to N next/previous window (wrap around) 
`<C-w> _` | "maximize" vertically
`<C-w> |` | "maximize" horizontally
`<C-w> H/J/K/L` | move window
`<C-w> x` | exchange with neighbor
`<C-w> r` | rotate
`<C-w> T` | move current window to a new tab page



# Plugins & other related

## NERDTree

|||
|-|-|
`?` | help
`F2` | [custom map] open NERDTree (default width)
`F3` | [custom map] toggle open/close
`C` | TREEROOT NAVIGATION - down
`U` | TREEROOT NAVIGATION - up
`u` | TREEROOT NAVIGATION - collapse tree & up
`CD`| TREEROOT NAVIGATION - go to pwd
`cd`| update pwd
`P` | jump to tree root
`p` | jump to parent
`O` | expand all sub-dirs
`X` | collapse all sub-dirs
`I` | toggle hidden
`R` | refresh



## Ctrl-P

|||
|-|-|
`?<CR>` | open help
`<C-b> <C-f>` | cycle between modes
`<C-d>` | toggle between full-path & filename only search
`<C-p> <C-n>` | prev/next searches



## Vimperator

[dotfile](https://github.com/cozywigwam/dotfiles/blob/master/.vimperatorrc)

|||
|-|-|
`:hs! [filter]` | history; use the bang to immediately open results
`o O` | open / open with current address populated
`t T` | new tab / new tab with "
`w W` | new window / new window with "
`p P` | open with clipboard (URL or search) / new tab with clipboard
`;` | extendended hint
`;;` | focus
`;F` | multiple background tabs
`;S` | save object
`;y` | yank location
`;#` | yank anchor URL
`;v` | view source
`;V` | open source in editor
`;c` | open context menu
`;i` & `;I` | open media object (& in new tab)
`m` | create mark
`M` | create quickmark
`:marks` | see marks
`:qmark j` | set "j"
`:qmarks j` | see "j"


## Fugitive

|||
|-|-|
`:Gwrite` | add %
`:Gread` | overwrite working with index
`:Gbrowse` | inspect current object on github.com

### :Gstatus

|||
|-|-|
`:Gstatus` | status
`g?` | show help
`D` | diff
`U` | co file, scrap changes (`:Gread` and `:w`)
`cc` | commit
`cA` | commit `--amend --use-message=HEAD`
`r` | reload
`q` | quit

### :Gdiff

|||
|-|-|
`:[range]diffget [bufspec]` | obtain diff
`:[range]diffput [bufspec]` | put diff
`do` | diff obtain
`dp` | diff put
`:diffget //3` | (from working copy of 3-way merge) obtain from merge branch
`:diffget //2` | same as above but obtain from target branch
`:Gwrite!` | (from target or merge branch) resolve conflicts with this version

### :Gedit

|||
|-|-|
`:Gedit [revision]` | e.g. `:Gedit HEAD^:%`
`<Enter>` | go to object corresponding to SHA on cursor's line
`C` | jump to commit object
`-` | jump to tree object

### [revision]

|||
|-|-|
`:h fugitive-revision` | `HEAD`, `master`, etc.
`HEAD^{}` | commit referenced by HEAD
`-` | current file in HEAD
`^` | current file in previous commit
`~3` | current file 3 commits ago
`:0` | current file in the index
`:2` | (3-way merge) current file in target branch
`:3` | (3-way merge) current file in merge branch


## Color

|||
|-|-|
`:edit $VIMRUNTIME/colors/README.txt` | colorscheme authorship
`:so $VIMRUNTIME/syntax/hitest.vim` | see highlight groups
`runtime syntax/colortest.vim` | test color setup 
