import styled, { css } from 'styled-components';

export const MQ = {
  xs: (...args) => css`
    @media (min-width: 420px) {
      ${css(...args)};
    }
  `,
  sm: (...args) => css`
    @media (min-width: 768px) {
      ${css(...args)};
    }
  `,
  md: (...args) => css`
    @media (min-width: 992px) {
      ${css(...args)};
    }
  `,
  lg: (...args) => css`
    @media (min-width: 1200px) {
      ${css(...args)};
    }
  `,
  xl: (...args) => css`
    @media (min-width: 1400px) {
      ${css(...args)};
    }
  `,
  xxl: (...args) => css`
    @media (min-width: 1900px) {
      ${css(...args)};
    }
  `,
};
