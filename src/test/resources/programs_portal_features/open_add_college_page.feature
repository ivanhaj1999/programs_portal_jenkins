Feature: open add college page in programs portal

  Background: user navigates to add college page in programs portal

    Scenario:user calls Web service and navigates to add college details page
      Given user will be in home page of programs portal
      When user clicks on menu button on top left corner
      And user clicks on master data management option
      And user clicks on colleges option
      Then user validates whether it navigated to add colleges page