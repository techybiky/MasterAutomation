Feature: Login functionality 

@instance_1
 	Scenario Outline: Login functionality 
 	Given User login to the CRM page
	When Title of login page is Login CRM
	Then User enter username "<username>" and User enter password "<password>"
	Then User click on Login button
	Then User is on Homepage
	Then Close the browser

	Examples:
 		| username | password |
 		|bikramadityadas1@gmail.com | Test@1234 |
 		|rockstardipu121@gmail.com | Bikram@1234 |