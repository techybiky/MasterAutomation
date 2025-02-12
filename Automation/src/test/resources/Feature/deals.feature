Feature: Create Deal functionality 

@instance_1
 	Scenario: Create a new deal 
 	Given User login to the CRM page
	When Title of login page is Login CRM
	Then User enter username and User enter password
	| username| password |
	| bikramadityadas1@gmail.com | Test@1234 |
	Then User click on Login button
	Then User is on Homepage
	Then User move to deal page and create a new deals
	| title | probability | amount | commission |
	| Deal06 | 10 | 100 | 200 |
	| Deal07 | 20 | 200 | 400 |
	| Deal08 | 30 | 300 | 600 |
	Then Close the browser