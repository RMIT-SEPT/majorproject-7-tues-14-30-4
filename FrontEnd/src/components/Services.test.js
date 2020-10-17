import React, { Component } from 'react'
import { render } from '@testing-library/react'
import Services from '../components/Services';
import { toBeInTheDocument } from '@testing-library/jest-dom'


describe("Services", () => {
  it("should render the services page", () => {
    const { getByText } = render(<Services />);
    const textExpected = getByText(/Our registered business services:/i);
    expect(textExpected).toBeInTheDocument();
  })
})
