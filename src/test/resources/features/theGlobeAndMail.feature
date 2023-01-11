Feature: The Globe And Mail homepage testing

@theglobeandmail @runthis
Scenario: End-User can successfully access The Globe And Mail homepage and its content
Given that I am an end-user that wants to get fresh news on The Globe And Mail website
When I navigate to The Globe And Mail website homepage
Then I am able to verify that the homepage is correctly loaded in my browser
And that the title of the homepage is The Globe And Mail
And that the content of the top menu is correct
And that there is a button to register that is clickable
And that there is also a Search button that is clickable

@theglobeandmail
Scenario: End-User can successfully starts the registration process on The Globe And Mail homepage and then cancel it
Given that I am an end-user that wants to register on The Globe And Mail website
When I navigate to The Globe And Mail website homepage
Then I am able to click on the Register button to open the register pop-up
When I enter my email address and password and postal code 
Then I can verify that my information entered is properly displayed in the form 
And that the CREATE MY FREE ACCOUNT button is clickable
When I click on the cross to close the register pop-up
Then I can verify that the register pop-up is closed 
And that I am back to the website homepage