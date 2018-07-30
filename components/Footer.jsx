import React from 'react';
import { Link } from 'react-router';

import { Footer, ReturnHomeLink, Hr } from '../components/styled/';

export default class MyFooter extends React.Component {
  render() {
    return (
      <Footer className="site-footer">
        <div className="u-text-align--center">
          <ReturnHomeLink to="/">☜</ReturnHomeLink>
        </div>
      </Footer>
    );
  }
}
