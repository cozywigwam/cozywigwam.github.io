---
title: "Markdowns & Similar"
layout: notation
description: Dialect Roundup
path: "/markdown/"
---

# Basics

```
*italics,* and _more italics_
**bold**
***bold italic***
```


# Tables

3 dash minimum, columns for alignment, line begin/end pipes optional. Header not required for gfm, but is seemeingly everywhere else.

```
| th | th | th |
| --- |:---:| ---:|
| left | middle | right |
```


# Dialects, variations

## Markdown

Daring Fireball's:

- <a href="http://daringfireball.net/projects/markdown/basics" target="_blank" alt="syntax/basics">basics</a>
- <a href="http://daringfireball.net/projects/markdown/syntax" target="_blank" alt="syntax/basics">syntax</a>

## github.com

Uses "<a href="https://help.github.com/articles/getting-started-with-writing-and-formatting-on-github/" target="_blank" alt="GitHub flavored markdown">GitHub flavored markdown</a>," aka GFM:

- <a href="https://help.github.com/articles/basic-writing-and-formatting-syntax/" target="_blank" alt="syntax">syntax</a>
- <a href="https://help.github.com/categories/writing-on-github/" target="_blank" alt="Writing on GitHub">Writing on GitHub</a>
- <a href="http://kramdown.gettalong.org/" target="_blank" alt="Kramdown">Kramdown</a>
- <a href="http://kramdown.gettalong.org/parser/gfm.html" target="_blank" alt="Kramdown parse info">Kramdown parse info</a>


## Stack Overfow

Code blocks are four indented spaces.

- Stack Overflow's <a href="http://stackoverflow.com/editing-help" target="_blank" alt="Markdown help">Markdown help</a>.

```
Here's an inline link to [Google](http://www.google.com/).
Here's a reference-style link to [Google][1].
Here's a very readable link to [Yahoo!][yahoo].

  [1]: http://www.google.com/
  [yahoo]: http://www.yahoo.com/
```



## Slack

Slack API <a href="https://api.slack.com/docs/message-formatting" target="_blank" alt="basic message formatting">basic message formatting</a>.


## JIRA

<a href="https://jira.atlassian.com/secure/WikiRendererHelpAction.jspa?section=all" target="_blank" alt="JIRA formatting">Formatting</a>

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

- <a href="https://github.com/jgm/CommonMark" target="_blank" alt="CommonMark">CommonMark on GitHub</a>
- <a href="http://spec.commonmark.org/0.26/" target="_blank" alt="CommonMark spec">CommonMark Spec</a>
- <a href="http://spec.commonmark.org/dingus/" target="_blank" alt="Dingus">"Dingus" (live tester)</a>
