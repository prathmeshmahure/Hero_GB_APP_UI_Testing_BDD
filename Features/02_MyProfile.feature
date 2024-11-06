Feature: My Profile


	
@Sanity
Scenario: Successfully update profile
  Given Click on at home page Icon button
	When User click on Menu icon
	Then Click on my profile 
	Then Click on more details
	And Click on edit profile details
	And Enter full name "Test User"
	And Enter email id "user.two@gmail.com"
	And Enter mobile number "17447946000"
	Then Enter address "Dhaka"
	And Select region Dhaka
	And Select town Dhaka
	Then Click on save button

@Sanity
Scenario: Successfully Upload licence pdf file
	Given Click on at home page Icon button
	When User click on Menu icon
  Then Click on my profile 
	And Click on driving licence
	And CLick on add now button

# @Test
#Scenario: Verify menu button 
#  Given Click on at home page Icon button
#	When User click on Menu icon
#	Then Click on my profile 


















@Sanity
Scenario: Successfully Upload licence pdf file
	Given Click on at home page Icon button
	When User click on Menu icon
  Then Click on my profile 
	And Click on driving licence
	And CLick on add now button
	