
  Feature: vehicleFeature
    As a User
    I want to Go through a file and read the vehicle registration details in this file
    So that I can complete this task

    Background: User navigates to Gov page to get vehicle information
      Given I am on the "Gov uk - Vechicle" page on Url "www.gov.uk/get-vehicle-information-from-dvla"
      And I see the "Start Now" landing page


    Scenario:
      Given I select "Start Now" to proceed to next page
      Then I see the "Registration Number" text box
      Then I read from a excel spreadsheet to provide a registration number
      Then I take a screenshot
      And Go back to enter another registration number
      Then I see the "Registration Number" text box
      Then I read from a excel spreadsheet to provide a another registration number
      Then I take another screenshot

