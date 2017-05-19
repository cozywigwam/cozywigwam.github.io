import styled, { injectGlobal, css } from 'styled-components';
import { darken, lighten } from 'polished';
import { Link } from 'react-router';
import { Row } from 'hedron';

const colors = {
  gray: "#26282a",
  grayDarker: "#222426",
  grayLighter: "#3a3a3a",
  white: "#f1f1f1",
  red: "#fe978b",
  green: "#d6fcba",
  yellow: "#fffed5",
  blue: "#c2e3ff",
  magenta: "#ffc6ff",
  cyan: "#c0e9f8"
}

const headerWidthMqDesktop = "20%";

/*
 * Media Queries
 */

const media = {
  xs: (...args) => css`
    @media (min-width: 420px) {
      ${ css(...args) }
    }
  `,
  sm: (...args) => css`
    @media (min-width: 768px) {
      ${ css(...args) }
    }
  `,
  md: (...args) => css`
    @media (min-width: 992px) {
      ${ css(...args) }
    }
  `,
  lg: (...args) => css`
    @media (min-width: 1200px) {
      ${ css(...args) }
    }
  `,
  xl: (...args) => css`
    @media (min-width: 1400px) {
      ${ css(...args) }
    }
  `,
  xxl: (...args) => css`
    @media (min-width: 1900px) {
      ${ css(...args) }
    }
  `
}

/*
 * Global Styles
 */
injectGlobal`
  @import url('https://fonts.googleapis.com/css?family=Theano+Modern&Norwester');

  html {
    background: ${colors.gray};
  }
  body {
    margin: 0;
    font-family: 'Theano Modern', serif;
    color: ${colors.white};
    background: ${colors.gray};
  }

  a {
    text-decoration: none;
    color: ${colors.yellow};

    &:hover {
      color: ${colors.red};
    }
    &:visited {
      color: ${colors.blue};
    }
    &:active {
      color: ${colors.magenta};
    }
  }

  table {
    border-collapse: collapse;
    font-family: "Inconsolata", monospace;
    margin-bottom: 2rem;
    background: ${colors.grayDarker};
    max-width: 1000px;
    border-bottom: 4px solid ${colors.magenta};
  }
  th, td {
    padding: 0.5rem 1rem;
    line-height: 1.8;
    border: 1px solid ${colors.grayLighter};

    ${media.sm`
      padding: 0.5rem 1.2rem;
    `}
    ${media.md`
      padding: 0.6rem 1.3rem;
    `}
    ${media.lg`
      padding: 0.6rem 1.4rem;
    `}
  }
  td {
    text-align: left;
    font-size: 13px;

    ${media.sm`
      font-size: 14px;
    `}
    ${media.lg`
      font-size: 15px;
    `}
    ${media.xl`
      font-size: 16px;
    `}
    ${media.xxl`
      font-size: 17px;
    `}
  }



  code {
    margin: 0 3px;
    padding: 2px 4px 5px 4px; // inline padding, overwritten below for code blocks
    font-size: 13px;
    background: ${colors.grayDarker};
    border-top: 1px solid ${colors.grayLighter};
    border-bottom: 1px solid ${colors.magenta}; // also overwritten below

    ${media.sm`
      font-size: 14px;
    `}
    ${media.lg`
      font-size: 15px;
    `}
    ${media.xl`
      font-size: 16px;
    `}
    ${media.xxl`
      font-size: 17px;
    `}
  }
  table code {
    font-family: "Inconsolata";
    background: none;
    border: 0;
  }
  table td > code:first-child {
    margin-left: 0;
    padding-left: 0;
  }

  .highlight {
    overflow-x: auto;
    padding: 16px 20px 20px;
    font-size: 11px;
    border: 1px solid ${colors.grayLighter};

    ${media.sm`
      padding: 28px 30px;
      font-size: 13px;
      `}
    ${media.md`
      font-size: 14px;
    `}
    ${media.lg`
      font-size: 15px;
    `}

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





h2 {
  color: ${colors.blue};
}




`;

export const Wrapper = styled.div`
    padding: 10% 6% 12%;

    ${media.sm`
      padding-top: 0;
      padding-bottom: 0;
    `}
    ${media.lg`
      margin-left: ${headerWidthMqDesktop};
    `}

    padding-top: ${props => props.homeWrapper || '10%'};
`;

export const Hr = styled.hr`
  max-width: 90%;
  height: 4px;
  margin: 10% auto 15% 0;
  background: ${colors.yellow};
  border-bottom: 2px solid ${colors.blue};
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
      color: ${colors.gray};
      background: ${colors.red};
    }
`;
export const StyledLink = styled(Link)`
    text-decoration: none;
`;

 export const StyledAnchor = styled.a`
   color: palevioletred;
   font-size: 18px;
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
  color: ${colors.white};
  font-size: 16px;
  font-weight: 600;
  background-color: black;
  border: 0;
  cursor: pointer;
`;

/*
 * DefaultButton
 */
export const DefaultButton = styled(Button)`
  background-color: lightblue;
  &:hover {
    background: ${darken(0.1, '#add8e6')};
  }
`;

/*
 * PrimaryButton
 */
export const PrimaryButton = styled(Button)`
  background-color: lightseagreen;
  &:hover {
    background: ${darken(0.1, '#20b2aa')};
  }
`;

/*
 * Success
 */
export const SuccessButton = styled(Button)`
  background-color: lightgreen;
  &:hover {
    background: ${darken(0.1, '#90ee90')};
  }
`;

/*
 * Warning
 */
export const WarningButton = styled(Button)`
  background-color: lightsalmon;
  &:hover {
    background: ${darken(0.1, '#ffa07a')};
  }
`;

/*
 * Danger
 */
export const DangerButton = styled(Button)`
  background-color: lightcoral;
  &:hover {
    background: ${darken(0.1, '#f08080')};
  }
`;

/*
 * Input
 */
export const Input = styled.input`
  color: ${props => props.color};
  font-size: 16px;
  padding: ${props => props.large ? '16px 48px' : '8px 24px'};
  border: 2px solid ${props => props.color};
  background: transparent;
`;

/*
 * Text
 */
export const Text = styled.p`
  font-size: ${props => props.fontSize || '16px'};
  ${ media.xs`
    font-size: 20px;
  ` }
`;

export const PostHeader = styled.div`
  padding-bottom: 60px;
`;
export const PostTitle = styled.h1`
  margin: 0.4em 0 .02em;
  font-size: 35px;
  font-family: 'Norwester';
  line-height: 1.4;
  color: ${colors.magenta};
`;
export const PostDescription = styled.h2`
  margin: 0.4em 0 .02em;
  font-size: 28px;
  font-family: 'Norwester';
  line-height: 1.4;
`;

/*
 * PostBody
 */
export const PostBody = styled.div`
 padding: 0px 50px;
 font-size: 17px;
 ${ media.xs`
   font-size: 20px;
 ` }
`;

/*
 * ErrorTitle
 */
export const ErrorTitle = styled.h4`
  font-size: 34px;
  margin-bottom: 0;
`;

/*
 * ErrorBody
 */
export const ErrorBody = styled.div`
  font-size: 18px;

  a {
    display: block;
    margin-top: 50px;
  }
`;
