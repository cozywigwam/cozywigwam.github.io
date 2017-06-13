import React from 'react';
import Helmet from 'react-helmet';

import { config } from 'config';

import Post from '../components/Post';
import Error from '../components/Error';
import Footer from '../components/Footer';

class MarkdownWrapper extends React.Component {
  render() {
    const { route } = this.props;
    const post = route.page.data;
    const layout = post.layout;
    let template;

    if (layout === 'notation' || layout == 'theme' || layout === 'page') {
      template = <Post {...this.props} />;
    } else if (layout === 'error') {
      template = <Error {...this.props} />;
    }

    return (
      <div>
        <Helmet title={`${config.siteTitle} - ${post.title}`} />
        {template}
        <Footer />
      </div>
    );
  }
}

export default MarkdownWrapper;
