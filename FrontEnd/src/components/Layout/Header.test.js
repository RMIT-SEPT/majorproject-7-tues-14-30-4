import React, { Component } from 'react'
import { render } from '@testing-library/react'
import Header from './Header'

test('renders title', () => {
  const { getByText } = render(<Header />);
  const linkElement = getByText(/Application/i);
  expect(linkElement).toBeInTheDocument();
});


