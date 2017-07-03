import React from 'react';
import Helmet from 'react-helmet';

import { config } from 'config';

import Post from '../components/Post';
import Footer from '../components/Footer';

class MarkdownWrapper extends React.Component {
  render() {
    const { route } = this.props;
    const post = route.page.data;

    return (
      <div>
        <Helmet title={`${config.siteTitle} - ${post.title}`} />
        <Post {...this.props} />
        <Footer />
      </div>
    );
  }
}

export default MarkdownWrapper;
