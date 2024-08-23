Feature: Validate Creating New Account successfully

  Scenario Outline: User creates a new account
    Given navigates to create new account tab
    When fill all the required data based on sentence from row: "<rowNumber>"
    And click on create account
    Then validate creating account successfully
    Examples:
      | rowNumber |
      | 1         |
      | 2         |
      | 3         |
