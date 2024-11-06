package GB_APP.StepDefinition;

import GB_APP.Utility.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest extends BaseTest{
	
	
//    @AdminLogin
	
	@Given("User Launch successfully Application")
	public void user_launch_successfully_application() {
		loginPg.user_launch_successfully_application();
	}
	@When("User allow permission")
	public void user_allow_permission() {
		loginPg.user_allow_permission();
	}
	@Then("User select country")
	public void user_select_country() {
		loginPg.user_select_country();
	}
	@Then("User select language")
	public void user_select_language() {
	    loginPg.user_select_language();
	}
	@When("User enters Email as {string}")
	public void user_enters_email_as(String string) {
		loginPg.user_enters_email_as(string);
	}
	@Then("Click on Continue button")
	public void click_on_continue_button() {
		loginPg.click_on_continue_button();
	}
	@Then("User enters Password as {string}")
	public void user_enters_password_as(String string) {
		loginPg.user_enters_password_as(string);
	}
	@Then("Click on Verify button")
	public void click_on_verify_button() {
		loginPg.click_on_verify_button();
	}
	@Then("Click on Allow permission button")
	public void click_on_allow_permission_button() {
		loginPg.click_on_allow_permission_button();
	}
	@Then("click on while using the app")
	public void click_on_while_using_the_app() {
		loginPg.click_on_while_using_the_app();
	}
	@Then("Click on proceed button")
	public void click_on_proceed_button() {
		loginPg.click_on_proceed_button();
	}
	@Then("close app")
	public void close_app() {
		loginPg.close_app();
	}
//========================================================================================================
//  @AdminLogin
	
	@Then("All country should be displayed")
	public void all_country_should_be_displayed() {
	   loginPg.all_country_should_be_displayed();
//	   loginPg.all_country_should_be_displayed111();
	}
//========================================================================================================
//  @AdminLogin	
	@Then("All language should be displayed")
	public void all_language_should_be_displayed() {
		loginPg.all_language_should_be_displayed();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
