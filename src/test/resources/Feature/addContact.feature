Feature: Add Contact functionality 

@instance_1
 	Scenario Outline: Login functionality 
 	Given User login to the CRM page
	When Title of login page is Login CRM
	Then User enter username "<username>" and User enter password "<password>"
	Then User click on Login button
	Then User is on Homepage
	Then User click on Add Contact and enter "<firstname>" and "<lastname>"
	Then Close the browser

	Examples:
 		| username | password | firstname | lastname |
 		|bikramadityadas1@gmail.com | Test@1234 | Bikram | Das |
 		|rockstardipu121@gmail.com | Bikram@1234 | Mukesh | Gupta |