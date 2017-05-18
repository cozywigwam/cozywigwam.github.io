import React from 'react';
import { Link } from 'react-router';

import {
  Footer,
  ReturnHomeLink,
  Hr
} from '../components/styled/';

export default class MyFooter extends React.Component {
  render() {
    return (
      <Footer className="site-footer">
        <ReturnHomeLink to="/">☜</ReturnHomeLink>
        <Hr />
        <img src="/cozy4.png" alt="cozy" />
      </Footer>
    );
  }
}
