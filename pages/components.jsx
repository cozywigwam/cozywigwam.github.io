import React from 'react';
import Helmet from 'react-helmet';
import { prefixLink } from 'gatsby-helpers';
import { Row, Column, Page } from 'hedron';
import { config } from 'config';
import _ from 'lodash';
import {
  Message,
  Subtitle,
  StyledLink
} from '../components/styled/';

export default class Components extends React.Component {
  render() {
    const { route } = this.props;
    const post = route.page.file;

    return (
      <Page>
      </Page>
    );
  }
}
