Feature: Login Functionality 

Scenario: Successful Login with Valid Credentials 

	Given User Launches the Web browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters LoginEmail as "admin@yourstore.com" and Password as "admin" 
	And Clicks on the Login button 
	Then The Page Title displayed should be "Dashboard / nopCommerce administration" 
	When User clicks on Log out link 
	Then The Page Title should be "Your store. Login" 
	Then  close the browser 
	
