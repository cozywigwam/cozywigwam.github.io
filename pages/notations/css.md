---
title: "CSS"
layout: notation
description: The Weird Kid at the Party
path: "/css/"
---


# General


## Reference

<a href="https://www.w3.org/Style/CSS/specs.en.html" target="_blank">CSS spec</a>


## Custom Properties


### Spec

<a href="https://www.w3.org/TR/css-variables/" target="_blank">W3</a>


### Syntax Examples

There are regular variables...:

    :root {
      --site-red: #f00;
    }
    h1 {
      var(--site-red);
    }

...and mixin-esque custom properties:

    :root {
      --an-argumentless-mixin: {
        color: red;
        border: 1px solid pink;
      }
    }
    .an-unargumentative-element {
      @apply --an-argumentless-mixin;
    }

These mixins might require the `Experimental Web Platform features` flag in Chrome, found here: `chrome://flags/#enable-experimental-web-platform-features`.

Here are both:

    :root {
      --my-var: red;
    
      --my-mixin: {
        color: var(--my-var);
        background: #ccc;
      }
    }
    .lucky-element {
      color: var(--my-var);
    }
    .extra-lucky-element {
      @apply --my-mixin;
    }

Note that you cannot overwrite a root variable used by a mixin:

    :root {
      --not-overwritten-var: 1px;
    
      --mixin: {
        width: var(--not-overwritten-var);
      }
    }
    .test-element {
      /* you can't do this */
      --not-overwritten-var: 10px;
    
      /* this mixin gets 1px, not 10px */
      @apply --mixin;
    }


### Links

Customization examples from a <a href="https://github.com/syl20bnr/spacemacs/issues/6649>" alt="popwin customizations" target="_blank">GitHub issue</a>:

<a href="https://google.com/" target="_blank">test</a>

Serg Hespodarets' <a href="https://blog.hospodarets.com/css_properties_in_depth" target="_blank">custom props in depth</a>, <a href="https://blog.hospodarets.com/css_apply_rule" target="_blank">native CSS mixins</a>, and on <a href="https://www.smashingmagazine.com/2017/04/start-using-css-custom-properties/" target="_blank">Smashing Magazine</a>.


## Nesting


### Descendent

Use `&` to refer to parent block:

    div {
      & > span {
        /* direct descendant */
        background: #eee;
      }
      & span {
        /* all within div */
        background: #bbb;
      }
      & ul {
        & span {
          /* this block's `&` refers to `ul`, not `div` */
          background: #999;
        }
      }
    }


### Ascendent

    .deep-element {
      color: black;
    
      /* note both `@nest` and `&` */
      @nest body.is-state & {
        color: red;
      }
    }


## Media Queries


### Top Level

    @media (min-width: 480px) {
      .box {
        padding: 20px;
      }
    }

    @custom-media --xs-max (max-width: 479px);
    @media (--xs-max) {}
    @custom-media --sm (min-width: 480px);
    @media (--sm) {}
    @custom-media --sm-max (max-width: 767px);
    @media (--sm-max) {}
    @custom-media --md (min-width: 768px);
    @media (--md) {}
    @custom-media --md-max (max-width: 991px);
    @media (--md-max) {}
    @custom-media --lg (min-width: 992px);
    @media (--lg) {}
    @custom-media --xl (min-width: 1200px);
    @media (--xl) {}
    @custom-media --xxl (min-width: 1600px);
    @media (--xxl) {}
    
    @media (width >= 500px) and (width <= 1200px) {}
    
    @custom-media --only-medium-screen (width >= 500px) and (width <= 1200px);
    @media (--only-medium-screen) {}


# CSS Modules

<a href="https://github.com/css-modules/css-modules" target="_blank">GitHub</a>
<a href="https://github.com/css-modules/icss" target="_blank">Interoperable CSS (ICSS)</a>


## Glen Maddern's intro

<a href="https://glenmaddern.com/articles/css-modules" target="_blank">Glen Maddern's introduction</a>

Each class gets all the styles it needs...

    /* components/submit-button.css */
    .normal { /* all styles for Normal */ }
    .disabled { /* all styles for Disabled */ }
    .error { /* all styles for Error */ }
    .inProgress { /* all styles for In Progress */

...by composing:

    .common {
      /* all the common styles you want */
    }
    .normal {
      composes: common;
      /* anything that only applies to Normal */
    }
    .disabled {
      composes: common;
      /* anything that only applies to Disabled */
    }
    .error {
      composes: common;
      /* anything that only applies to Error */
    }
    .inProgress {
      composes: common;
      /* anything that only applies to In Progress */
    }


### Compose between files

    /* colors.css */
    .primary {
      color: #720;
    }
    .secondary {
      color: #777;
    }
    /* other helper classes... */


### More examples

    .element {
      composes: large from "./typography.css";
      composes: dark-text from "./colors.css";
      composes: padding-all-medium from "./layout.css";
      composes: subtle-shadow from "./effect.css";
    }
    
    /* this short hand: */
    .element {
      composes: padding-large margin-small from "./layout.css";
    }
    
    /* is equivalent to: */
    .element {
      composes: padding-large from "./layout.css";
      composes: margin-small from "./layout.css";
    }
    
    /* more examples ... */
    .article {
      composes: flex vertical centered from "./layout.css";
    }
    
    .masthead {
      composes: serif bold 48pt centered from "./typography.css";
      composes: paragraph-margin-below from "./layout.css";
    }
    
    .body {
      composes: max720 paragraph-margin-below from "layout.css";
      composes: sans light paragraph-line-height from "./typography.css";
    }


# postcss


## cssnext


### Phenomic setup

Directory setup (with the global styles file renamed and moved to `styles/`):

    .
    ├── content
    │   ├── assets
    │   │   └── portfolio
    │   ├── pages
    │   └── ...
    ├── dist
    ├── scripts
    └── src
        ├── components
        │   └── ...
        ├── layouts
        │   └── ...
        └── styles
    
    ./
    package.json
    postcss.config.js
    variables.js
    webpack.config.js
    
    ./src/styles/
    headings.css
    highlight.css
    mixins.css
    phenomic-base.css
    reset.css
    styles.global.css

    /* styles.global.css */
    @import './reset.css';
    @import './phenomic-base.css';
    
    @import './mixins.css';
    @import './headings.css';
    @import './highlight.css';

In order to import these CSS files, add `require('postcss-import')(),` to `postcss.config.js`:

    // postcss.config.js
    const vars = require('./variables.js');
    
    module.exports = (config) => [
        require("stylelint")(),
        require('postcss-import')(),
        require("postcss-cssnext")({
          // ref: http://cssnext.io/usage/
          browsers: "last 2 versions",
          features: {
            customProperties: {
              variables: vars,
            },
          },
        }),
        require("postcss-reporter")(),
        ...!config.production ? [
          require("postcss-browser-reporter")(),
        ] : [],
      ]

Also note the external `variables.js` file:

    // variables.js
    module.exports = {
      myVar: 'orange',
    }


### links

-   <a href="http://cssnext.io/" target="_blank">cssnext home</a>
-   <a href="http://ricostacruz.com/cheatsheets/cssnext.html" target="_blank">Rico St. Cruz's cheatsheet</a>


## browserlist

<a href="https://css-tricks.com/browserlist-good-idea/" target="_blank">Chris Coyier's write-up</a>


# Styled Components


## Example directly to a Styled Component

    
    // /App.js
    import { OrangeSpan } from './styled/Button.js'
    // ...
    <div>
      <OrangeSpan/>
    </div>
    
    // /styled/Button.js
    import React from 'react'
    import styled from 'styled-components';
    
    export const OrangeSpan = styled.span`
      background: orange;
    `


## Example to an intermediate component inside styled/comp.js

    
    // /App.js
    import { Button } from './styled/Button.js'
    // ...
    <div>
      <Button/>
    </div>
    
    
    // /styled/Button.js
    import React from 'react'
    import styled from 'styled-components';
    
    const ButtonThatMovesPerOpen = styled.div`
      position: absolute;
      margin-left: ${(props) => (props.open) ? `${props.width}px` : 'none'};
      transition: margin .2s;
    `
    export const Button = (props) => {
      return (
        <ButtonThatMovesPerOpen {...props}>
          <span onClick={props.toggle}>button</span>
        </ButtonThatMovesPerOpen>
      )
    }


# Misc


## Styles in HTML <head>

CSS Styles in the head <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/style" target="_blank">MDN</a>

    <link href="styles/main.css" rel="stylesheet">
    
    <style>
        body { display: none; }
    </style>
    
    <!-- optional [MIME] `type` attribute defauts to `text/css`, i.e. <style type="text/css" /> -->


## Paragraph line width in em

Proper main-content line lengths, in em, <a href="http://maxdesign.com.au/articles/ideal-line-length-in-ems/" target="_blank">ref</a>:

> As you can see, the average seems to suggest that your container width should be set between the narrowest width of 21em (approx 49 characters per line) to the widest width of 30em (approx 71 characters per line).


## blockquote

    <figure class="quote">
    	<blockquote><p>...the author hopes to be held guiltless by those to whom the work is addressed—enlightened souls who prefer dry wines to sweet, sense to sentiment, wit to humor and clean English to slang.</p></blockquote>
    	<figcaption>Ambrose Bierce, <cite>The Devil's Dictionary</cite></figcaption>
    </figure>


## clearfix

    .clearfix:after {
      content: "";
      display: table;
      clear: both;
    }


## text selection

`::selection { ... }`

