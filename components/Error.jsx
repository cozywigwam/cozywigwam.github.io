import React from 'react';
import { Column, Row } from 'hedron';
import { prefixLink } from 'gatsby-helpers';

export default class Error extends React.Component {
  render() {
    const { route } = this.props;
    const { body } = route.page.data;

    return (
      <Row>
        <Column>
          <h1>Yikes!</h1>
        </Column>
        <Column>
          <div>
            <div dangerouslySetInnerHTML={{ __html: body }} />
            <Link to={prefixLink('/')}>back home</Link>
          </div>
        </Column>
      </Row>
    );
  }
}
