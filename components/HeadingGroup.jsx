import React from 'react';

import { Link } from 'react-router';

import { PostHeader, H1, StyledLink, PostDescription } from './styled/';

const HeadingGroup = props => {
  return (
    <PostHeader>
      <H1>
        {props.path ? (
          <StyledLink white to={props.path}>
            {props.title}
          </StyledLink>
        ) : (
          `${props.title}`
        )}
      </H1>
      <PostDescription>
        {props.descLink ? (
          <a href={props.descLink}>{props.description}</a>
        ) : (
          `${props.description}`
        )}
      </PostDescription>
    </PostHeader>
  );
};

export default HeadingGroup;
