describe("Google Title Test", () => {
  it("Should be Title visible", () => {
    cy.visit("https://www.google.com/");
    cy.title().should("eq", "Google");
  });
});
