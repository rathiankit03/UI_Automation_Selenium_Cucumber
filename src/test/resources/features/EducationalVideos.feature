Feature: Educational Video Feature

  @regression
  Scenario Outline: Validate if Lesson 1.1 video plays for minimum 5 seconds in different screen resolution
    Given I am on home page with screen size "<screen size>"
    When I click Research and Education menu
    And I click Education Videos link
    And I click Lesson 1.1 video
    Then Educational video should play for a minimum of 5 seconds

    Examples:
      | screen size |
      | max         |
      | 1024 x 768  |
      | 800 x 600   |