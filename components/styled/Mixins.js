import { Constants } from './Constants';

export const Mixins = {
  fontSizer: (baseSize, multiplier) => {
    return `
      font-size: ${baseSize}px;

      @media (min-width: ${Constants.MQ.sm}px) {
        font-size: ${baseSize * multiplier.sm}px;
      }
      @media (min-width: ${Constants.MQ.md}px) {
        font-size: ${baseSize * multiplier.md}px;
      }
      @media (min-width: ${Constants.MQ.lg}px) {
        font-size: ${baseSize * multiplier.lg}px;
      }
      @media (min-width: ${Constants.MQ.xl}px) {
        font-size: ${baseSize * multiplier.xl}px;
      }
      @media (min-width: ${Constants.MQ.xxl}px) {
        font-size: ${baseSize * multiplier.xxl}px;
      }
    `;
  },
};
