Feature: AdminLogin 


@AdminLogin
Scenario: Successful Verify All Country
	Given User Launch successfully Application 
	When User allow permission 
	Then All country should be displayed
	And close app
	
@AdminLogin
Scenario: Successful Verify All Language
	Given User Launch successfully Application 
	When User allow permission 
	Then User select country
	And Click on Continue button
	Then All language should be displayed
	And close app
	
@AdminLogin
Scenario: Successful Login with Valid Credentials
	Given User Launch successfully Application 
	When User allow permission 
	Then User select country
	Then Click on Continue button
	And User select language
	Then Click on Continue button
	And User enters Email as "user.two@gmail.com"  
	Then Click on Continue button
	And User enters Password as "123456" 
	Then Click on Verify button
	Then Click on Continue button
	And Click on Allow permission button
	Then click on while using the app
	And Click on proceed button	
	


	
