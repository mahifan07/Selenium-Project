Feature: Automate the following workflows using the Page Object Model (POM) in the swaglabs web application.
    
Scenario: Login to swaglaps application
    Given user is on the swagLaps application
    When user enters the username "standard_user" amd password "secret_sauce"
    And user clicks on login button
    Then verfiy the login activity
    And add the products in the cart
    | Product Name             |
    | Sauce Labs Backpack      |
    | Sauce Labs Bolt T-Shirt  |
    | Sauce Labs Fleece Jacket |

    