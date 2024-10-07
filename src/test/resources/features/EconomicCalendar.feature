Feature: Economic Calendar Feature

  @regression
  Scenario Outline: Validate if correct date is displayed when we select today, tomorrow and next week on slider
    for different screen resolution
    Given I am on home page with screen size "<screen size>"
    When I click Research and Education menu
    And I click Economic Calendar link
    Then I navigate to Economic Calendar page
    And I should get correct date as I select today, tomorrow and next week on slider

     Examples:
       | screen size |
       | max         |
       | 1024 x 768  |
       | 800 x 600   |