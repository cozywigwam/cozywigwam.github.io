import React from 'react';
import Helmet from 'react-helmet';
import { prefixLink } from 'gatsby-helpers';
import { Page, Row, Column } from 'hedron';
import { config } from 'config';
import _ from 'lodash';
import moment from 'moment';
import uuid from 'uuid';
import HeadingGroup from '../components/HeadingGroup';
import {
  Message,
  StyledLink
} from '../components/styled/';

export default class Blog extends React.Component {
  renderPosts(route) {
    const posts = [];
    route.pages.map(page => {
      if (page.data.layout === 'post') {
        posts.push(page);
      }
    });

    const ordered = _.sortBy(posts, o => {
      return new moment(o.data.date);
    }).reverse();

    return ordered.map(orderedPost => {
      return <HeadingGroup key={uuid()} title={ orderedPost.data.title } description={ orderedPost.data.description } path={ orderedPost.data.path } />
    });
  }

  render() {
    const { route } = this.props;

    return (
      <Page>
        <Helmet title={`${config.siteTitle} - Blog`} />
        <Row divisions={1}>
          <Column sm={1}>
            <StyledLink to={prefixLink('/')}>back home</StyledLink>
          </Column>
          <Column sm={1}>
            <Message>From our blog</Message>
          </Column>
        </Row>
        <Row>
          <Column>
            {this.renderPosts(route)}
          </Column>
        </Row>
      </Page>
    );
  }
}
