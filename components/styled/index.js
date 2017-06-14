import styled, { injectGlobal, css } from 'styled-components';
import { darken, lighten } from 'polished';
import { Link } from 'react-router';
import { Row } from 'hedron';

import { Font } from './Font';
import { Colors } from './Colors';
import { MQ } from './MQ';
import { Constants } from './Constants';
import { Mixins } from './Mixins';


/*
 * Global Styles
 */
injectGlobal`
  @import url('https://fonts.googleapis.com/css?family=Theano+Modern&Norwester');

  html {
    background: ${Colors.gray};
  }
  body {
    margin: 0;
    font-family: ${Font.family.default};
    line-height: ${Font.lineHeight.regular};
    color: ${Colors.white};
    background: ${Colors.gray};

    ${Mixins.fontSizer(18, Constants.multipliers.regular)}
  }

  a {
    text-decoration: none;
    color: ${Colors.yellow};

    &:hover {
      color: ${Colors.red};
    }
    &:visited {
    }
    &:active {
      color: ${Colors.magenta};
    }
  }

  img {
    display: block;
    padding: 1em 0 2.5em;
    max-width: 100%;
  }
  blockquote {
    margin-left: 0;
    margin-bottom: 2rem;
    padding: 0.5rem 2rem;
    ${Mixins.fontSizer(13, Constants.multipliers.regular)}
    font-style: italic;
    border-left: 1px solid ${Colors.yellow};
  }

  table {
    border-collapse: collapse;
    margin-bottom: 2rem;
    background: ${Colors.grayDarker};
    max-width: 1000px;
    border-bottom: 4px solid ${Colors.magenta};
  }
  thead {
    display: none;
  }
  td {
    padding: 0.5rem 1rem;
    line-height: ${Font.lineHeight.extended};
    border: 1px solid ${Colors.grayLighter};
    text-align: left;
    ${Mixins.fontSizer(14, Constants.multipliers.regular)}

    @media (min-width: ${Constants.MQ.sm}px) {
      padding: 0.5rem 1.2rem;
    }
    @media (min-width: ${Constants.MQ.md}px) {
      padding: 0.6rem 1.3rem;
    }
    @media (min-width: ${Constants.MQ.lg}px) {
      padding: 0.6rem 1.4rem;
    }
  }

  /*
   * Three types of code...
   */
  code {
    margin: 0 3px;
    padding: 1px 5px 3px;
    font-family: ${Font.family.monospace};
    ${Mixins.fontSizer(16, Constants.multipliers.regular)}
    background: ${Colors.grayDarker};
    border-bottom: 1px solid ${Colors.grayLighter};
  }
  table code {
    background: none;
    border: 0;
    ${Mixins.fontSizer(13, Constants.multipliers.regular)}
  }
  table td > code:first-child {
    margin-left: 0;
    padding-left: 0;
  }

  pre {
    overflow-x: auto;
    padding: 16px 20px 20px;
    ${Mixins.fontSizer(13, Constants.multipliers.regular)}
    border: 1px solid ${Colors.grayLighter};

    @media (min-width: ${Constants.MQ.sm}px) {
      padding: 28px 30px;
    }
  }
  pre code {
    margin: 0;
    padding: 0;
    ${Mixins.fontSizer(14, Constants.multipliers.regular)}
    line-height: ${Font.lineHeight.extended};
    background: none;
    border: 0;
  }



  pre + p,
  pre + ul,
  pre + ol,
  pre + blockquote,
  pre + table {
    // margin-top: 3.2rem;
  }
  table + table,
  pre + pre {
    // margin-top: 4rem;
  }




  h1, h2, h3, h4, h5, h6 {
    margin: 1.4em 0 0.8em;
    font-family: ${Font.family.heading};
    font-weight: normal;
    line-height: 1.8;
    margin: 1.4em 0 .8em;
    letter-spacing: 0.05em;
    cursor: default;

    a {
      cursor: pointer;
    }
  }

  h1 {
    ${Mixins.fontSizer(Font.size.base.heading.h1, Constants.multipliers.heading)}
    color: ${Colors.white};
  }
  h2 {
    ${Mixins.fontSizer(Font.size.base.heading.h2, Constants.multipliers.heading)}
    color: ${Colors.blue};
  }
  h3 {
    ${Mixins.fontSizer(Font.size.base.heading.h3, Constants.multipliers.heading)}
    color: ${Colors.green};
  }
  h4 {
    ${Mixins.fontSizer(Font.size.base.heading.h4, Constants.multipliers.heading)}
    color: ${Colors.yellow};
  }
  h5 {
    ${Mixins.fontSizer(Font.size.base.heading.h5, Constants.multipliers.heading)}
    color: ${Colors.cyan};
  }
  h6 {
    ${Mixins.fontSizer(Font.size.base.heading.h6, Constants.multipliers.heading)}
  }




`;

export const Wrapper = styled.div`
  max-width: 800px;
  padding: 10% 3% 12%;

  ${MQ.lg`
    padding-left: ${Constants.headerWidthMqDesktop};
  `}
`;

export const Hr = styled.hr`
  max-width: 600px;
  height: 4px;
  margin: 10% auto 15% 0;
  background: ${Colors.yellow};
  border-bottom: 2px solid ${Colors.blue};
`;
export const Footer = styled.footer`
  padding: 0 3% 8%;

  ${MQ.lg`
    padding-left: ${Constants.headerWidthMqDesktop};
  `}
  img {
    padding: 0;
  }
`;
export const Header = styled.header`
  height: 60px;

  img {
    padding: 0;
  }
 `;

export const Logo = styled(Link)`
    position: fixed;
    top: -80px;
    right: 16px;
    display: block;
    transform: scaleX(-1);
 `;

export const ReturnHomeLink = styled(Link)`
    display: inline-block;
    margin: 5% 0;
    padding: 1em 2em;
    color: $body-copy;
    font-size: 15px;

    &:hover {
      color: ${Colors.gray};
      background: ${Colors.red};
    }
`;
export const StyledLink = styled(Link)`
  ${props => props.white ? `color: ${Colors.white};` : '' }
`;

export const Message = styled.h2`
  font-size: 27px;
  text-decoration: underline;
`;

/*
 * Button
 */
export const Button = styled.button`
  padding: ${props => props.large ? '16px 48px' : '8px 24px'};
  color: ${Colors.white};
  font-size: 16px;
  font-weight: 600;
  background-color: black;
  border: 0;
  cursor: pointer;
`;
export const Input = styled.input`
  color: ${props => props.color};
  font-size: 16px;
  padding: ${props => props.large ? '16px 48px' : '8px 24px'};
  border: 2px solid ${props => props.color};
  background: transparent;
`;
export const PostHeader = styled.div`
  padding-bottom: 60px;
`;
export const H1 = styled.h1`
  color: ${Colors.white};
  margin: 0.4em 0 .02em;
  line-height: 1.4;
`;
export const PostDescription = styled.h2`
  margin: 0 0 .02em;
  line-height: 1.4;
`;
