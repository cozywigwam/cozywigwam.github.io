---
title: "Browsers"
layout: notation
description: Remember Netscape
path: "/browsers/"
---

# Chrome

## dev tools

[Console API Reference](https://developers.google.com/web/tools/chrome-devtools/console/console-reference)

[Command Line API Reference](https://developers.google.com/web/tools/chrome-devtools/console/command-line-reference)

|||
|-|-|
`cmd + shift + P` | [command menu](https://developers.google.com/web/tools/chrome-devtools/ui#command-menu)
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

## Cookies

[reference](https://developers.google.com/web/tools/chrome-devtools/manage-data/cookies)

In Applications -> Storage

## Run Chromium with flags

From [The Chromium Projects](http://www.chromium.org/developers/how-tos/run-chromium-with-flags):

```
/Applications/Chromium.app/Contents/MacOS/Chromium --remote-debugging-port=9222

# for Google Chrome you'll need to escape spaces like so:
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --remote-debugging-port=9222
```

## Take a screenshot

`cmd + shift + P` -> "Capture Screenshot"

## Empty Devtools Popups

Clear cache in `chrome://appcache-internals/`: [https://github.com/googlearchive/ADBPlugin/issues/14](reference) 

## Vimium

[dotfile](https://raw.githubusercontent.com/cozywigwam/dotfiles/master/.vimium)

## Reference

[Keyboard shortcuts reference](https://developers.google.com/web/tools/chrome-devtools/shortcuts)

# Chromium

## [Chromium Development Calendar and Release Info](https://www.chromium.org/developers/calendar)

| Release | 	 Estimated Week of Stable               |
|---------|---------------------------------------------|
|      64 | Jan 23rd, 2018 (Jan 30th for Chrome OS)     |
|      65 | Mar 6th, 2018 (Mar 13th for Chrome OS)      |
|      66 | April 17th, 2018 (April 24th for Chrome OS) |
|      67 | May 29th, 2018 (June 5th for Chrome OS)     |
|      68 | July 24th, 2018 (July 31st for Chrome OS)   |
|      69 | Sept 4th, 2018 (Sept 11th for Chrome OS)    |
|      70 | Oct 16th, 2018 (Oct 23rd for Chrome OS)     |
|      71 | Dec 4th, 2018 (Dec 11th for Chrome OS)      |

# Firefox

## Shortcuts

[Mozilla keyboard shortcuts](https://developer.mozilla.org/en-US/docs/Tools/Keyboard_shortcuts)

## Locations

Help -> Troubleshooting Information

- `about:config`
- `about:support`
- `about:plugins`
- `about:buildconfig`
- `about:memory`
- `about:performance`
- `about:serviceworkers`
- `~/Library/Application Support/Firefox/Profiles/`
- `~/Library/Mozilla/Firefox/Profiles/`

## Cookies

[Reference](https://developer.mozilla.org/en-US/docs/Tools/Storage_Inspector#Cookies)

In the Storage panel.


## Vimperator

[dotfile](https://raw.githubusercontent.com/cozywigwam/dotfiles/master/.vimperatorrc)

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
