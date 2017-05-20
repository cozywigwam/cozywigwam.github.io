import React from 'react';
import Helmet from 'react-helmet';
import { prefixLink } from 'gatsby-helpers';
import { Row, Column, Page } from 'hedron';
import { config } from 'config';
import _ from 'lodash';
import {
  Message,
  StyledLink,
  Text
} from '../components/styled/';

export default class About extends React.Component {
  render() {
    const { route } = this.props;
    const post = route.page.file;

    return (
      <Page>
        <Helmet title={`${config.siteTitle} - ${_.capitalize(post.name)}`} />
        <Row divisions={1}>
          <Column sm={1}>
            <StyledLink to={prefixLink('/')}>back home</StyledLink>
          </Column>
          <Column sm={1}>
            <Message>About Superstylin'</Message>
          </Column>
        </Row>
        <Row>
          <Column>
            <p>about_bak.jsx</p>
          </Column>
        </Row>
      </Page>
    );
  }
}
