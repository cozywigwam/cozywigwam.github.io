---
layout: post
title: "Regex"
categories: notation
subtitle: Rolex & Rolodex
---

BRE recognized metacharacters:
- `^`
- `$`
- `.`
- `[`
- `]`
- `*`

ERE additions:
- `(`
- `)`
- `{`
- `}`
- `?`
- `+`
- `|`

ERE all:
- `^`
- `$`
- `.`
- `[`
- `]`
- `*`
- `(`
- `)`
- `{`
- `}`
- `?`
- `+`
- `|`

[PCRE home](http://www.pcre.org/)

# Emacs

[Emacs Lisp - syntax of regular expressions manual](https://www.gnu.org/software/emacs/manual/html_node/elisp/Syntax-of-Regexps.html#Syntax-of-Regexps)

`(`, `)`, and `|` will match exactly, so they must be escaped: `\(`, `\)`, `\|`.

## [Special Characters](https://www.gnu.org/software/emacs/manual/html_node/elisp/Regexp-Special.html#Regexp-Special)

| `.`              | any except newline |
| `*`              |
| `+`              |
| `?`              |
| `*?`, `+?`, `??` | non-greedy |
| `[` ... `]`      | character alternative |
| `[^` ... `]`     | "complemented" (non-matching) character alternative |
| `^`              |
| `$`              |
| `\`              |

> Note that ‘\’ also has special meaning in the read syntax of Lisp strings (see String Type), and must be quoted with ‘\’. For example, the regular expression that matches the ‘\’ character is ‘\\’. To write a Lisp string that contains the characters ‘\\’, Lisp syntax requires you to quote each ‘\’ with another ‘\’. Therefore, the read syntax for a regular expression matching ‘\’ is "\\\\".

## [Character Classes](https://www.gnu.org/software/emacs/manual/html_node/elisp/Char-Classes.html#Char-Classes)

| `[:ascii:]`     |
| `[:alnum:]`     |
| `[:alpha:]`     |
| `[:blank:]`     |
| `[:cntrl:]`     |
| `[:digit:]`     |
| `[:graph:]`     |
| `[:lower:]`     |
| `[:multibyte:]` |
| `[:nonascii:]`  |
| `[:print:]`     |
| `[:punct:]`     |
| `[:space:]`     |
| `[:unibyte:]`   |
| `[:upper:]`     |
| `[:word:]`      |
| `[:zdigit:]`    |

## [Backslash Constructs in Regular Expressions](https://www.gnu.org/software/emacs/manual/html_node/elisp/Regexp-Backslash.html#Regexp-Backslash)

| `\                 |
| `\{m\}`            |
| `\{m,n\}`          |
| `\(` ... `\)`      |
| `\(?:` ... `\)`    |
| `\(?num:` ... `\)` |
| `\digit`           |
| `\w`               |
| `\W`               |
| `\scode`           |
| `\Scode`           |
| `\cc`              |
| `\Cc`              |
| `\[backtick]`      |
| `\'`               |
| `\=`               |
| `\b`               |
| `\B`               |
| `\<`               |
| `\>`               |
| `\_<`              |
| `\_>`              |

# Misc

Perl uses a "slightly larger and richer set of notations" (The Linux Command Line: A Complete Introduction, William E. Schotts, Jr.).
