import React, { Component } from 'react'
import { render } from '@testing-library/react'
import Dashboard from '../components/Dashboard';
import { toBeInTheDocument } from '@testing-library/jest-dom'
import TestingRouter from './TestHelper'



// test('renders title', () => {
//   const { getByText } = render(<Dashboard />);
//   const linkElement = getByText(/User Dashboard/i);
//   expect(linkElement).toBeInTheDocument();
// });

describe('Check that redirection works', () => {
  it('has to redirect', () => {

    const redirectUrl = 'User Dashboard'
    const data = { status: 'closed' }

    const { container } = render(
      <TestingRouter
        ComponentWithRedirection={() => <Dashboard data={data} />}
        RedirectUrl={redirectUrl}
      />
    )

    expect(container.innerHTML).toEqual(
      expect.stringContaining(redirectUrl)
    )
  })
})
