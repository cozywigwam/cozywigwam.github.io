import React from 'react';
import Helmet from 'react-helmet';

import { config } from 'config';
import { prefixLink } from 'gatsby-helpers';

import _ from 'lodash';
import moment from 'moment';
import uuid from 'uuid';

import HeadingGroup from '../components/HeadingGroup';

import {
  Wrapper,
  Hr
} from '../components/styled/';

export default class Index extends React.Component {
  renderNotationHeadingGroups(route, layout) {
    const posts = [];
    route.pages.map(page => {
      if (page.data.layout === layout) {
        posts.push(page);
      }
    });

    return posts.map(post => {
      return <HeadingGroup key={uuid()} title={ post.data.title } description={ post.data.description } path={ post.data.path } />
    });
  }

  render() {
    return (
      <div>
        <Helmet title={config.siteTitle} meta={[{ 'name': 'description', 'content': 'code 127' }]} />

        <Wrapper homeWrapper>
          { this.renderNotationHeadingGroups(this.props.route, 'notation') }
          <Hr />
          { this.renderNotationHeadingGroups(this.props.route, 'theme') }
          <Hr />
          <HeadingGroup path={prefixLink('/about/')} title="About" description="@cozywigwam" descLink="https://twitter.com/cozywigwam" />
        </Wrapper>
      </div>
    )
  }
}
