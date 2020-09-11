import { validateFormData } from './Validation';

test("should print 2 when input is 2", () => {
  // Arrange
  const input = '2';
  const expecting = '2';
  // Act
  const result = validateFormData(input, expecting);
  // Assert
  expect(result).toEqual(input);
}
)

test("should fail if expecting 4 and recieve 2", () => {
  const input = '2';
  const expecting = '4'
    expect(() => {
      validateFormData(input, expecting)
    }).toThrow()
})

test("should fail if expecting something and recieve nothing", () => {
    const input = null;
    const expecting = '4'
      expect(() => {
        validateFormData(input, expecting)
      }).toThrow()
  })