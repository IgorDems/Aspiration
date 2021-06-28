#Author:Igor Demchenko
#Aspiration.com Smoke Test Demo 
@SmokeScenario 
Feature: Login to "aspiration.com" 
@SmokeTest 
Scenario Outline:: Verify that as a user,they can view our products, 
	and prices by navigating from the home page "https://aspiration.com/" to the products page
  via the “Spend & Save”

	Given Browser is open 
	When User enters aspiration.com 
	And  Hits enter 
	Then User have to see Aspiration home_page 
	
	
	
	Given User had navigated to Home_page 
	When User clicked Spend&Save link at the top of the home page 
	Then User can see two card products, Aspiration and Aspiration_Plus
	

	
	Given  User on Spend&Save page 
	When   User clicked GetAspiration button
	Then  A modal input field for an emailaddress are displayed
	And   A modal  sign_up button are displayed 

	
	Given  User on Spend&Save page 
	When   User clicked GetAspirationPlus button 
	Then  A modal with monthly and yearly plans are displayed 
	And  Yearly radio option the is <text1> and visible 
	And  Monthly radio option is <text2> and visible 
	Examples: 
	|planname 					| text1                   | text2               |
	|"getAspirationplus" | "$71.88 paid once yearly" | "$7.99 paid monthly"|