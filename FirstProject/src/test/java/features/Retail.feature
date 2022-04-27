Feature: Signin feature

  @Regression
  Scenario Outline: Verify retail site Login page

    Given User navigated to the Login page
    And Enter Username "<username>" and password "<password>"
    When user is navigated successfully to the  Home page
    And Created coupons
    Then validate the Coupon ,Edit  the coupon
    And Delete Coupon



    Examples:
    |username| |password|
    |admin        | |Admin@123        |




