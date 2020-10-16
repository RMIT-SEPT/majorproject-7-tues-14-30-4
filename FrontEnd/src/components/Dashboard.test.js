import React, { Component } from 'react'
import { render } from '@testing-library/react'
import Dashboard from '../components/Dashboard';
import { toBeInTheDocument } from '@testing-library/jest-dom'
import TestingRouter from './TestHelper'


describe("Dashboard", () => {
  it("should render the dashboard", () => {
    const { getByText } = render(<Dashboard />);
    const textExpected = getByText(/Please Sign in to view this page/i);
    expect(textExpected).toBeInTheDocument();
  })
})

