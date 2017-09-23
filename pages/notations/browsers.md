---
title: "Browsers"
layout: notation
description: Remember Netscape
path: "/browsers/"
---

# Chrome

## dev tools

<a href="https://developers.google.com/web/tools/chrome-devtools/console/console-reference" target="_blank" alt="Console API Reference">Console API Reference</a>

<a href="https://developers.google.com/web/tools/chrome-devtools/console/command-line-reference" target="_blank" alt="Command Line API Reference">Command Line API Reference</a>

|||
|-|-|
`$_` | previous expression's evaluation
`$0` – `$4` | most recently inspected elements
`$('img')` | `document.querySelector()` alias
`$$('img')` | `document.querySelectorAll()` alias
`$x("//p[a]")` | XPath
`copy($0)` | copy to clipboard
`debug(myFuncName)` & `undebug()` | break on `myFuncName()`
`dir(document.body)` & `dirxml()` | list properties
`inspect(object/function)` | go to Elements or Profiles
`keys(object)` & `values(object)` |
`getEventListeners(object)` |
`monitorEvents(object[, events])` |
`F2` | (with element selected) edit as HTML

## Vimium

<a href="https://raw.githubusercontent.com/cozywigwam/dotfiles/master/.vimium" target="_blank" alt="vimium">dotfile</a>


# Firefox

## Shortcuts

[Mozilla keyboard shortcuts](https://developer.mozilla.org/en-US/docs/Tools/Keyboard_shortcuts)

## Locations

- `about:config`
- `about:support`
- `~/Library/Application Support/Firefox/Profiles/`
- `~/Library/Mozilla/Firefox/Profiles/`

## Vimperator

<a href="https://raw.githubusercontent.com/cozywigwam/dotfiles/master/.vimperatorrc" target="_blank" alt="vimperatorrc">dotfile</a>

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


## Misc

To add "confirm on quit": `about:config`, `browser.showQuitWarning`




# Safari

|||
|-|-|
`cmd + opt + r` | responsive
