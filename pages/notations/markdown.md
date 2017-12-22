---
title: "Markdowns & Similar"
layout: notation
description: Dialect Roundup
path: "/markdown/"
---

# Quick Syntax Reference

## Basics

```
| th   | th     | th    |
| :--- | :---:  | ---:  |
| left | middle | right |

*italics*, _alt italics_

**bold**, __alt bold__

***bold italic***, ___alt bold italic___

> quote

~~strike through~~

`code`

[site](example.com)
```

| th   | th     | th    |
| :--- | :---:  | ---:  |
| left | middle | right |

*italics*, _alt italics_

**bold**, __alt bold__

***bold italic***, ___alt bold italic___

> quote

~~strike through~~

`code`

[site](example.com)


# Dialects, variations

## Chart

| daring fireball          | Slack     | JIRA                   | SO                  |
|--------------------------|-----------|------------------------|---------------------|
| *italics*, _alt italics_ |           |                        |                     |
| __double underscore__    |           |                        |                     |
| **bold**                 |           |                        |                     |
| ***bold italic***        |           |                        |                     |
| > quote                  | >         | {quote}..{quote}       |                     |
| ~~strike through~~       |           |                        |                     |
| `code`                   | `inline`  | {{inline}}             | `inline`            |
| code block               | backticks | {code}..{code}         | indent              |
| [site](example.com)      | n/a       | [site\vertexample.com] | [site](example.com) |

## Markdown

Daring Fireball's:

- [basics](http://daringfireball.net/projects/markdown/basics)
- [syntax](http://daringfireball.net/projects/markdown/syntax)

## GitHub

Uses "[GitHub flavored markdown]( target=)," aka GFM:

- [syntax](https://help.github.com/articles/basic-writing-and-formatting-syntax/)
- [Writing on GitHub](https://help.github.com/categories/writing-on-github/)
- [Kramdown](http://kramdown.gettalong.org/)
- [Kramdown parse info](http://kramdown.gettalong.org/parser/gfm.html)


## Stack Overflow

Code blocks are four indented spaces.

- Stack Overflow's [Markdown help](http://stackoverflow.com/editing-help).

```
Here's an inline link to [duckduckgo](http://www.duckduckgo.com/).

Here's a reference-style link to [duckduckgo][1].

Here's a very readable link to [duckduckgo][ddg].

  [1]: https://www.duckduckgo.com/
  [ddg]: https://www.duckduckgo.com/
```

Here's an inline link to [duckduckgo](http://www.duckduckgo.com/).

Here's a reference-style link to [duckduckgo][1].

Here's a very readable link to [duckduckgo][ddg].

  [1]: https://www.duckduckgo.com/
  [ddg]: https://www.duckduckgo.com/

## Slack

[syntax](https://get.slack.help/hc/en-us/articles/202288908-Format-your-messages) and [formatting](https://api.slack.com/docs/message-formatting)

Use single backticks for inline code/monospace, and triple backticks (fencing) for code blocks. Shift+enter for line breaks. Disable markup processing with `mrkdwn` set to `false`:

```
> to blockquote one paragraph
>>> to blockquote multiple paragraphs
```

```json
{
  "mrkdwn": false,
  "text": "*This will not be bold.* It will be surrounded gloriously with stars."
}
```

Note: Hyperlinking words and terms in a Slack message isn't supported. ([link](https://get.slack.help/hc/en-us/articles/204399343-Sharing-links-in-Slack))


## JIRA

[JIRA formatting](https://jira.atlassian.com/secure/WikiRendererHelpAction.jspa?section=all)

```
{{inline-code}}

{code} or {code:javascript}
  return;
{code}

link to [this site|https://thissite.com]

h1. heading 1

h2. heading 2

bq. This is one line of block quote

{quote}
This is multiple lines
of block quote
{quote}

- bullet
- bullet

* also bullet
* also bullet

# numbered
# numbered
```



## CommonMark

An attempt "to specify Markdown syntax unambiguously."

- [CommonMark on GitHub](https://github.com/jgm/CommonMark)
- [CommonMark Spec](http://spec.commonmark.org/0.26/)
- ["Dingus" (live tester)](http://spec.commonmark.org/dingus/)

# Misc

Ambiguity: https://meta.stackexchange.com/a/99637
