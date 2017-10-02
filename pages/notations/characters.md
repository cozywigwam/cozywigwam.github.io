---
title: "Characters"
layout: notation
description: Of Distinction & Re Distinguishing
path: "/characters/"
---

# Insert a character

|||
|-|-|
`C-x 8 RET` | `insert-char` [for normal mode] (unicode name, hex, or code point with `#`-specified radix)
`C-q` | `quoted-insert` [for insert mode] insert literally

# "What character is this?"

<a href="http://unicodelookup.com/#119082" target="_blank" alt="Double sharp at unicodelookup.com">unicodelookup.com</a>

|||
|-|-|
`ga` | [Vim] get character info at cursor
`SPC h d c` | [Spacemacs] get character info at point

## Sample output

Example character: 🥑

Vim lookup (`ga`):

```
<🥑> 129361, Hex 0001f951, Octal 374521
```

Spacemacs lookup (`SPC h d c` | `describe-char`):

```
             position: 1475 of 1476 (100%), column: 0
            character: 🥑 (displayed as 🥑) (codepoint 129361, #o374521, #x1f951)
    preferred charset: unicode (Unicode (ISO10646))
code point in charset: 0x1F951
               script: symbol
               syntax: w 	which means: word
             category: .:Base
             to input: type "C-x 8 RET 1f951" or "C-x 8 RET AVOCADO"
          buffer code: #xF0 #x9F #xA5 #x91
            file code: #xF0 #x9F #xA5 #x91 (encoded by coding system utf-8-unix)
              display: no font available

Character code properties: customize what to show
  name: AVOCADO
  general-category: So (Symbol, Other)
  decomposition: (129361) ('🥑')

There are 2 overlays here:
 From 1475 to 1475
  before-string        [Show]
  linum-str            [Show]
 From 1475 to 1475
  before-string        [Show]
  fringe-helper-parent #<overlay from 926 to 1475 in about.md>


There are text properties here:
  fontified            t

[back]
```
# Make characters macOS (hold ⌥)

|||
|-|-|
| ` | *modifier to create grave accent* |
| 1 | ¡ |
| 2 | ™ |
| 4 | ¢ |
| 5 | ∞ |
| 6 | § |
| 7 | ¶ |
| 8 | • |
| 9 | ª |
| 0 | º |
| - | – |
| = | ≠ |
| q | œ |
| w | ∑ |
| e | *modifier to create acute accent* |
| r | ® |
| t | † |
| y | ¥ |
| u | *modifier to create umlaut* |
| i | *modifier to create circumflex* |
| o | ø |
| p | π |
| [ | “ |
| * | ‘ |
| \ | « |
| a | å |
| s | ß |
| d | ∂ |
| f | ƒ |
| g | © |
| h | ˙ |
| j | ∆ |
| k | ˚ |
| l | ¬ |
| ; | … |
| ' | æ |
| z | Ω |
| x | ≈ |
| c | ç |
| v | √ |
| b | ∫ |
| n | *modifier to add énye* |
| m | µ |
| , | ≤ |
| . | ≥ |
| / | ÷ |

# Misc

|||
|-|-|
| ⇧ | shift arrow |
| ⌘ | looped square |
| ⌥ | option |
| ♭ | flat |
| ♯ | sharp |
| ♮ | natural |
| 𝄪 | double sharp |
| ∯ | surface integral |

<a href="http://ascii-code.com/" target="_blank" alt="ascii-code.com">ascii-code.com</a>

