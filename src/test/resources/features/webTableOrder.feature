Feature: Web table user order feature


  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "American express"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/25"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table


  Scenario Outline: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    @femaleScientist
    Examples: Famous female scientist
      | productType | quantity | customerName      | street    | city   | state   | zipCode | cardType         | cardNumber       | expDate | expectedName      |
      | MoneyCog    | 2        | Marie Curie       | London st | London | England | 55605   | Visa             | 1111222233334444 | 12/25   | Marie Curie       |
      | Familybea   | 3        | Lady Gaga         | London st | London | England | 55605   | Mastercard       | 1111222233334444 | 12/25   | Lady Gaga         |
      | Screenable  | 4        | Rosalind Franklyn | London st | London | England | 55605   | American Express | 1111222233334444 | 12/25   | Rosalind Franklyn |
      | MoneyCog    | 5        | Madonna           | London st | London | England | 55605   | Visa             | 1111222233334444 | 12/25   | Madonna           |
      | MoneyCog    | 6        | Queen Elisabeth   | London st | London | England | 55605   | Visa             | 1111222233334444 | 12/25   | Queen Elisabeth   |
    @maleScientist
    Examples: Famous male scientist
      | productType | quantity | customerName      | street    | city   | state   | zipCode | cardType         | cardNumber       | expDate | expectedName      |
      | MoneyCog    | 2        | Charles Darwin    | London st | London | England | 55605   | Visa             | 1111222233334444 | 12/25   | Charles Darwin    |
      | Familybea   | 3        | Cristiano Ronaldo | London st | London | England | 55605   | Mastercard       | 1111222233334444 | 12/25   | Cristiano Ronaldo |
      | Screenable  | 4        | Nicolae Ceausescu | London st | London | England | 55605   | American Express | 1111222233334444 | 12/25   | Nicolae Ceausescu |
      | MoneyCog    | 5        | Albert Einstein   | London st | London | England | 55605   | Visa             | 1111222233334444 | 12/25   | Albert Einstein   |
      | MoneyCog    | 6        | Marcus Rashford   | London st | London | England | 55605   | Visa             | 1111222233334444 | 12/25   | Marcus Rashford   |