import React from 'react';

import {
  Header,
  Logo
} from '../components/styled/';

export default class MyHeader extends React.Component {
  render() {
    return (
      <Header className="site-header">
        <Logo to="/">
          <img src="/colorbars2.png" alt="colorbars" />
        </Logo>
      </Header>
    );
  }
}
