---
title: "Markdowns & Similar"
layout: notation
description: Dialect Roundup
path: "/markdown/"
---

# Quick Syntax Reference

## Basics

```
*italics,* and _more italics_
**bold**
***bold italic***
```

## Tables

3 dash minimum, columns for alignment, line begin/end pipes optional. Header not required for gfm, but is seemeingly everywhere else.

```
| th | th | th |
| --- |:---:| ---:|
| left | middle | right |
```


# Dialects, variations

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
Here's an inline link to [Google](http://www.google.com/).
Here's a reference-style link to [Google][1].
Here's a very readable link to [Yahoo!][yahoo].

  [1]: http://www.google.com/
  [yahoo]: http://www.yahoo.com/
```



## Slack

[syntax](https://get.slack.help/hc/en-us/articles/202288908-Format-your-messages) and [formatting](https://api.slack.com/docs/message-formatting)

Use single backticks for inline code/monospace, and triple backticks (fencing) for code blocks. Shift+enter for line breaks. Disable markup processing with `mrkdwn` set to `false`:

```json
{
  "mrkdwn": false,
  "text": "*This will not be bold.* It will be surrounded gloriously with stars."
}
```

> Note: Hyperlinking words and terms in a Slack message isn't supported. ([link](https://get.slack.help/hc/en-us/articles/204399343-Sharing-links-in-Slack))

### quotes/blockquotes

```
> one long line
>>> multiline paragraphs
```


## JIRA

[JIRA formatting](https://jira.atlassian.com/secure/WikiRendererHelpAction.jspa?section=all)

```
{{inline-code}}

{code} or {code:javascript}
  return;
{code}

link to [this site|https://thissite.com]

bq. This is one line of block quote

{quote}
This is multiple lines
of block quote
{quote}
```



## CommonMark

An attempt "to specify Markdown syntax unambiguously."

- [CommonMark on GitHub](https://github.com/jgm/CommonMark)
- [CommonMark Spec](http://spec.commonmark.org/0.26/)
- ["Dingus" (live tester)](http://spec.commonmark.org/dingus/)
