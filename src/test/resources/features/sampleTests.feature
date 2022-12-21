Feature: The Globe And Mail homepage testing

@test
Scenario: End-User can successfully access The Globe And Mail homepage
Given that I am an end-user that wants to get fresh news on The Globe And Mail website
When I navigate to The Globe And Mail website
Then I am able to verify that the homepage is correctly loaded in my browser
And that the title of the homepage is The Globe And Mail
And that there is a button to register that is clickable
And that there is also a Search button that is clickable