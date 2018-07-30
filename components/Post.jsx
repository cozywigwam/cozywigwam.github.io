import React from 'react';

import HeadingGroup from '../components/HeadingGroup';

import { Wrapper } from './styled/';

export default class Post extends React.Component {
  render() {
    const { route } = this.props;
    const { title, body, description } = route.page.data;

    return (
      <Wrapper>
        <HeadingGroup
          title={route.page.data.title}
          description={route.page.data.description}
        />
        <div dangerouslySetInnerHTML={{ __html: body }} />
      </Wrapper>
    );
  }
}
