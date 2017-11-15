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

## Emacs

[Mastering Emacs](https://www.masteringemacs.org/article/diacritics-in-emacs) reference


| `C-\`            | `toggle-input-method`   | notice the appearance of `1>` in the mode line |
| `f1 C-\`, `f1 I` | `describe-input-method` |                                                |
|                  | `default-input-method`  | see what you're toggling on/off                |

When the `latin-1-prefix` "input method" is activated (this is the input method recommended by EmacsWiki & Mastering Emacs), the following accent characters can be entered by typing the desired prefix and then the character (see this with `describe-input-method`):

| effect     | prefix | examples                                             |
|------------|--------|------------------------------------------------------|
| acute      | \='    | \='a -> á, \='\=' -> ´                               |
| grave      | \=`    | \=`a -> à                                            |
| circumflex | ^      | ^a -> â                                              |
| diaeresis  | "      | "a -> ä  "" -> ¨                                     |
| tilde      | ~      | ~a -> ã                                              |
| cedilla    | ~      | ~c -> ç                                              |
| breve      | ~      | ~a -> ă                                              |
| caron      | ~      | ~c -> č                                              |
| dot above  | ~ / .  | ~o -> ġ   /o -> ġ   .o -> ġ                          |
| misc       | " ~ /  | "s -> ß  ~d -> ð  ~t -> þ  /a -> å  /e -> æ  /o -> ø |
| symbol     | ~      | ~> -> »  ~< -> «  ~! -> ¡  ~? -> ¿  ~~ -> ¸          |
| symbol     | _ /    | _o -> º  _a -> ª  // -> °  /\ -> ×  _y -> ¥          |
| symbol     | ^      | ^r -> ®  ^c -> ©  ^1 -> ¹  ^2 -> ²  ^3 -> ³          |

Note: when the input method is toggled off, the key chord bindings stop functioning. Turn `key-chord-mode` off and back on to regain use of the bindings.


# "What character is this?"

[unicodelookup.com](http://unicodelookup.com/#119082)

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

|   |                                   |                                  |
|---|-----------------------------------|----------------------------------|
| ` | *modifier to create grave accent* | accent grave                     |
| 1 | ¡                                 |                                  |
| 2 | ™                                 |                                  |
| 4 | ¢                                 |                                  |
| 5 | ∞                                 |                                  |
| 6 | §                                 |                                  |
| 7 | ¶                                 |                                  |
| 8 | •                                 |                                  |
| 9 | ª                                 |                                  |
| 0 | º                                 |                                  |
| - | –                                 |                                  |
| = | ≠                                 |                                  |
| q | œ                                 |                                  |
| w | ∑                                 |                                  |
| e | *modifier to create acute accent* |                                  |
| r | ®                                 |                                  |
| t | †                                 |                                  |
| y | ¥                                 |                                  |
| u | *modifier to create umlaut*       |                                  |
| i | *modifier to create circumflex*   |                                  |
| o | ø                                 |                                  |
| p | π                                 |                                  |
| [ | “                                 |                                  |
| * | ‘                                 |                                  |
| \ | «                                 |                                  |
| a | å                                 |                                  |
| s | ß                                 |                                  |
| d | ∂                                 |                                  |
| f | ƒ                                 |                                  |
| g | ©                                 |                                  |
| h | ˙                                 |                                  |
| j | ∆                                 |                                  |
| k | ˚                                 |                                  |
| l | ¬                                 |                                  |
| ; | …                                 |                                  |
| ' | æ                                 | æsc or ash grapheme, ae ligature |
| z | Ω                                 | omega                            |
| x | ≈                                 |                                  |
| c | ç                                 | c with cedilla                   |
| v | √                                 | square root                      |
| b | ∫                                 |                                  |
| n | *modifier to add énye*            | énye                             |
| m | µ                                 | mu                               |
| , | ≤                                 | less than or equals              |
| . | ≥                                 | greater than or equals           |
| / | ÷                                 | obelus                           |

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

[ascii-code.com](http://ascii-code.com/)


# Reference

[Ogonek vs. Cedilla](http://www.personal.psu.edu/ejp10/blogs/gotunicode/2009/01/ogonek-vs-cedilla-accent.html)
