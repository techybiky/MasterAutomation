Feature: Database Validation Test

  @instace_1
  Scenario: Retrieve user details from the database
    Given I connect to the database
    When I execute the query "SELECT * FROM anyjob.employees;"
    Then I should see the query result