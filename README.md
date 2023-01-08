# UPaymentStudyCase
  

## 👨🏿‍💻 Scenario

```cucumber
Feature: Product Module Tests - UPayments
  Product Module Tests with cucumber

  Background: Precondition
    Given I go to upayment login page
    When I fill in the username field "htest@emailaddress.com"
    And I fill in the password field "123456"
    And I click the login button
    And I click on the store area from the menu
    And I click on the product field from the store menu area
    Then I see the product page open

  Scenario Outline: Successful product addition test
    Given I click the Add Product button
    When I am uploading the product image "<ImageLocation>"
    And I enter the product name "<ENName>" EN
    And I enter the product name "<ARName>" AR
    And I select the product category "<Category>"
    And I enter the product price "<Price>"
    And I click the Submit button
    Then I see "<Notification>" in notification area

    Examples:
      | ENName | ARName   | ImageLocation | Category    | Price | Notification                |
      | Book   | BookAR   | book.png      | Electronics | 15    | Product added successfully. |
      | Pencil | PencilAR | pencil.png    | Electronics | 25    | Product added successfully. |

  Scenario Outline: Successful product update test
    Given I fill "<Search_ENName>" in the Thumbnail field
    When I click the search button
    And I click the update button of the filtered "<Search_ENName>" product
    And I am uploading the product image "<ImageLocation>"
    And I enter the product name "<ENName>" EN
    And I enter the product name "<ARName>" AR
    And I select the product category "<Category>"
    And I enter the product price "<Price>"
    And I click the Submit button
    Then I see "<Notification>" in notification area

    Examples:
      | Search_ENName | ENName        | ARName          | ImageLocation | Category    | Price | Notification                  |
      | Book          | BookUpdated   | BookARUpdated   | book.png      | Electronics | 15    | Product updated successfully. |
      | Pencil        | PencilUpdated | PencilARUpdated | pencil.png    | Electronics | 25    | Product updated successfully. |

  Scenario Outline: Successful product deletion test
    Given I fill "<Search_ENName>" in the Thumbnail field
    When I click the search button
    And I click the delete button of the filtered product "<Search_ENName>"
    And Are you sure? I click the OK button on the notification
    Then I see "<Notification>" in notification area

    Examples:
      | Search_ENName       | Notification |
      | BookBookUpdated     | Success      |
      | PencilPencilUpdated | Success      |

  Scenario Outline: Successful product search test
    Given I fill "<Search_ENName>" in the Thumbnail field
    When I click the search button
    Then I'm verifying that the "<Notification>" notification shows no data in the table

    Examples:
      | Search_ENName       | Notification               |
      | BookBookUpdated     | No data available in table |
      | PencilPencilUpdated | No data available in table |
```
 
