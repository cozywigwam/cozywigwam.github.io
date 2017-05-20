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
      color: ${Colors.blue};
    }
    &:active {
      color: ${Colors.magenta};
    }
  }

  table {
    border-collapse: collapse;
    font-family: "Inconsolata", monospace;
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
    line-height: 1.8;
    border: 1px solid ${Colors.grayLighter};
    text-align: left;
    ${Mixins.fontSizer(13, Constants.multipliers.regular)}

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

  code {
    margin: 0 3px;
    padding: 1px 5px 3px;
    ${Mixins.fontSizer(16, Constants.multipliers.regular)}
    background: ${Colors.grayDarker};
    border-bottom: 1px solid ${Colors.grayLighter};
  }
  table code {
    font-family: "Inconsolata";
    background: none;
    border: 0;
    ${Mixins.fontSizer(13, Constants.multipliers.regular)}
  }
  table td > code:first-child {
    margin-left: 0;
    padding-left: 0;
  }

  .highlight {
    overflow-x: auto;
    padding: 16px 20px 20px;
    ${Mixins.fontSizer(13, Constants.multipliers.regular)}
    border: 1px solid ${Colors.grayLighter};

    @media (min-width: ${Constants.MQ.sm}px) {
      padding: 28px 30px;
    }

    code {
      margin: 0;
      padding: 0;
      background: none;
      border: 0;
    }
  }



  .highlighter-rouge + h4,
  .highlighter-rouge + h5,
  .highlighter-rouge + p,
  .highlighter-rouge + ul,
  .highlighter-rouge + ol,
  .highlighter-rouge + blockquote,
  .highlighter-rouge + table {
    margin-top: 3.2rem;
  }
  table + h2,
  table + h3,
  .highlighter-rouge + h2,
  .highlighter-rouge + h3 {
    margin-top: 3.8rem;
  }
  table + table,
  .highlighter-rouge + .highlighter-rouge {
    margin-top: 4rem;
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

  h2 {
    color: ${Colors.blue};
  }




`;

export const Wrapper = styled.div`
    padding: 10% 6% 12%;

    ${MQ.sm`
      padding-top: 0;
      padding-bottom: 0;
    `}
    ${MQ.lg`
      margin-left: ${Constants.headerWidthMqDesktop};
    `}

    padding-top: ${props => props.homeWrapper || '10%'};
`;

export const Hr = styled.hr`
  max-width: 90%;
  height: 4px;
  margin: 10% auto 15% 0;
  background: ${Colors.yellow};
  border-bottom: 2px solid ${Colors.blue};
`;
export const Footer = styled.footer`
  padding: 0 6% 8%;
`;
export const Header = styled.header`
    height: 60px;
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
    text-decoration: none;
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
export const PostTitle = styled.h1`
  margin: 0.4em 0 .02em;
  line-height: 1.4;
`;
export const PostDescription = styled.h2`
  margin: 0.4em 0 .02em;
  line-height: 1.4;
`;
