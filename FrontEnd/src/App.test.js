import React from 'react';
import { render } from '@testing-library/react';
import App from './App';
import { toBeInTheDocument } from '@testing-library/jest-dom'

test('renders Home link', () => {
  const { getByText } = render(<App />);
  const linkElement = getByText(/Home/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders required information', () => {
    const { getByText } = render(<App />);
    const linkElement = getByText(/Welcome to AGME's Online Appointment Booking System/i);
    expect(linkElement).toBeInTheDocument();
});

test('renders Sign in link', () => {
    const { getByText } = render(<App />);
    const linkElement = getByText(/Sign In/i);
    expect(linkElement).toBeInTheDocument();
  });