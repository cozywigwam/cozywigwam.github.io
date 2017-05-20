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

- [introduction] (philosophy)
- [basics]
- [syntax].

[introduction]: http://daringfireball.net/projects/markdown/ "Daring Fireball markdown introduction"
[basics]: http://daringfireball.net/projects/markdown/ "Daring Fireball markdown basics"
[syntax]: http://daringfireball.net/projects/markdown/basics "Daring Fireball markdown syntax"



## github.com

Uses "[GitHub Flavored Markdown]," aka GFM:

- [Syntax]
- [Writing on GitHub root]
- [Kramdown parse info].

[GitHub flavored markdown]: https://help.github.com/articles/getting-started-with-writing-and-formatting-on-github/
[Syntax]: https://help.github.com/articles/basic-writing-and-formatting-syntax/
[Writing on GitHub root]: https://help.github.com/categories/writing-on-github/
[Kramdown parse info]: http://kramdown.gettalong.org/parser/gfm.html


## GitHub Pages & Jekyll

As of [Feb 1 2016], GitHub Pages is Jekyll 3.0, which is *only* [kramdown].

[kramdown]: http://kramdown.gettalong.org/
[Feb 1 2016]: https://github.com/blog/2100-github-pages-now-faster-and-simpler-with-jekyll-3-0







## Stack Overfow

Code blocks are four indented spaces.

- Stack Overflow's [markdown help].

[Markdown help]: http://stackoverflow.com/editing-help

```
Here's an inline link to [Google](http://www.google.com/).
Here's a reference-style link to [Google][1].
Here's a very readable link to [Yahoo!][yahoo].

  [1]: http://www.google.com/
  [yahoo]: http://www.yahoo.com/
```



## Slack

Slack API [basic message formatting].

[basic message formatting]: https://api.slack.com/docs/message-formatting


## JIRA

Formatting: https://jira.atlassian.com/secure/WikiRendererHelpAction.jspa?section=all

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

An attempt "to specify Markdown syntax unambiguously." [Spec], [GitHub]. ["Dingus" (live tester)].

[GitHub]: https://github.com/jgm/CommonMark
[Spec]: http://spec.commonmark.org/0.26/
["Dingus" (live tester)]: http://spec.commonmark.org/dingus/
