---
layout: post
title: "Markdowns & Similar"
categories: cheatsheet
subtitle: Dialect roundup
---

### Basics

```
*italics,* and _more italics_

**bold**

***bold italic***
```


#### Tables

3 dash minimum, colors for alignment, line begin/end pipes optional.

```
| th | th | th |
| --- |:---:| ---:|
| left | middle | right |
```


### Dialects, variations

#### Markdown

Add `.text` to some URLs. For instance, Jon Gruber's [intro].

Daring Fireball's [introduction] (philosophy), [basics], and [syntax].

[intro]: http://daringfireball.net/projects/markdown/basics.text
[introduction]: http://daringfireball.net/projects/markdown/ "Daring Fireball markdown introduction"
[basics]: http://daringfireball.net/projects/markdown/ "Daring Fireball markdown basics"
[syntax]: http://daringfireball.net/projects/markdown/basics "Daring Fireball markdown syntax"



#### github.com

Uses ["GitHub Flavored Markdown,"] aka GFM: [Syntax], [Writing on GitHub root](https://help.github.com/categories/writing-on-github/). [Kramdown parse info].

["GitHub flavored markdown,"]: https://help.github.com/articles/getting-started-with-writing-and-formatting-on-github/
[Syntax]: https://help.github.com/articles/basic-writing-and-formatting-syntax/
[Writing on GitHub root]: https://help.github.com/categories/writing-on-github/
[Kramdown parse info]: http://kramdown.gettalong.org/parser/gfm.html


#### GitHub Pages & Jekyll

As of [Feb 1 2016], GitHub Pages is Jekyll 3.0, which is *only* [kramdown].

[kramdown]: http://kramdown.gettalong.org/
[Feb 1 2016]: https://github.com/blog/2100-github-pages-now-faster-and-simpler-with-jekyll-3-0







#### Stack Overfow

Stack Overflow's [markdown help].

[Markdown help]: http://stackoverflow.com/editing-help

Code blocks are four indented spaces.


#### Slack

Slack API [basic message formatting].

[basic message formatting]: https://api.slack.com/docs/message-formatting


#### JIRA

{% raw %}
```bash
{{inline-code}}

{code} or {code:javascript}
  return;
{code}

link to [this site|https://thissite.com]
```
{% endraw %}



#### CommonMark

An attempt "to specify Markdown syntax unambiguously." [Spec], [GitHub]. ["Dingus" (live tester)].

[GitHub]: https://github.com/jgm/CommonMark
[Spec]: http://spec.commonmark.org/0.26/
["Dingus" (live tester)]: http://spec.commonmark.org/dingus/
