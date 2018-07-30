import React from 'react';

import { Header, Logo } from './styled/';

export default class MyHeader extends React.Component {
  render() {
    return (
      <Header className="site-header">
        <Logo to="/">
          <img src="/assets/colorbars2.png" alt="colorbars" />
        </Logo>
      </Header>
    );
  }
}
