import React from 'react';

import { Link } from 'react-router';

import {
  PostHeader,
  PostTitle,
  PostDescription
} from './styled/';

const HeadingGroup = props => {
  return (
    <PostHeader>
      <PostTitle>
        { props.path
          ? <Link to={props.path}>{props.title}</Link>
          : `${props.title}` }
      </PostTitle>
      <PostDescription>
        { props.descLink
          ? <a href={"descLink:" + props.descLink}>{props.description}</a>
          : `${props.description}` }
      </PostDescription>
    </PostHeader>
  )
}

export default HeadingGroup
