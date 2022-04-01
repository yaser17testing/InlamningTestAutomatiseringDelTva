Feature: Inlamning

  Scenario: Create Account
    Given I have written my email "yaser_hassan@hotmail.com"
    Given I have written my username "yaser_hassan1167349985"
    Given I have written my password "Yaser123_"
    When I click the signup button
    Then Another page is displayed,with a textmessage


    Scenario: Creating an existing account
      Given I have written my email "yaser_hassan@hotmail.com"
      Given I have written an existing username "Chucky"
      Given I have written my password "Yaser123_"
      When I click the signup button
      Then it cannot create an account




    Scenario: Create account with at least 100chars
      Given I have written my email "yaser_hassan@hotmail.com"
      Given I have written my username ,at lest 100chars "yyyyyyyyyyaaaaaaaaaasssssssssseeeeeeeeeerrrrrrrrrryyyyyyyyyyaaaaaaaaaasssssssssseeeeeeeeeerrrrrrrrrryyyyyyyyyyaaaaaaaaaasssssssssseeeeeeeeeerrrrrrrrrr"
      Given I have written my password "Yaser123_"
      When I click the signup button
      Then It cannot Create account, to many chars
      




      Scenario: Create account without a mail
        Given I have write my username "yaser_hassan@hotmail.com"
        Given I have write my password "Yaser123_"
        When I click on the signup button
        Then It cannot create an account,mail missing