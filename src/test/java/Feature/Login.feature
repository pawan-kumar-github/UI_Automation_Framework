Feature: This is the feature file

  @Regression
  Scenario Outline: <Scenario> formyear E2E
    Given Navigate to ToolsQA home page and gofor registration
    When Visit Demo site "<Name>"
    And Do experiment with Alert Window
    Then End the session and show report
    Examples:
      | Scenario | Name  | Pass |
      | Tools QA    | pawan | P@   |
#      | PEP    | wrong | P@   |
#      | right | P@   |

##  @Smoke
#  Scenario Outline: <Scenario> formyear E2E
#    Given Navigate to ToolsQA home page and gofor registration
##    When Visit Demo site
##    And Do experiment with Alert Window
#    Then End the session and show report
#    Examples:
#      | Scenario | Name  | Pass |
#      | Tools QA    | pawan | P@   |
#      | PEP    | wrong | P@   |
##      | right | P@   |