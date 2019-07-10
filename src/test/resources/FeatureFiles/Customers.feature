Feature: Customers  

Background:
Given User Launches the Web browser 
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters LoginEmail as "admin@yourstore.com" and Password as "admin"
And Clicks on the Login button 
Then The Page Title displayed should be "Dashboard / nopCommerce administration" 

Scenario: Login with Valid Credentials 
When User clicks on Log out link 
Then The Page Title should be "Your store. Login"  
Then  close the browser 


Scenario: Add new customers
When User clicks on customers Menu 
And clicks on customers Menu Item 
Then User can view Add new customer page 
When User enter customer info 
And click on Save button 
Then User can view confirmation message "The new customer has been added successfully." 
And close browser
