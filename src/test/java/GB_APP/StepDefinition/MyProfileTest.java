package GB_APP.StepDefinition;

import java.io.IOException;

import GB_APP.Utility.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyProfileTest extends BaseTest {

// My profile
	@Given("Click on at home page Icon button")
	public void click_on_at_home_page_icon_button() {
		myp.click_on_at_home_page_icon_button();
	}
	@When("User click on Menu icon")
	public void user_click_on_menu_icon() {
		myp.user_click_on_menu_icon();
	}
	@Then("Click on my profile")
	public void click_on_my_profile() {
		myp.click_on_my_profile();
	}
	@Then("Click on more details")
	public void click_on_more_details() {
		myp.click_on_more_details();
	}
	@Then("Click on edit profile details")
	public void click_on_edit_profile_details() {
		myp.click_on_edit_profile_details();
	}
	@Then("Enter full name {string}")
	public void enter_full_name(String string1) {
		myp.enter_full_name(string1);
	}
	@Then("Enter email id {string}")
	public void enter_email_id(String string) {
		myp.enter_email_id(string);
	}
	@Then("Enter mobile number {string}")
	public void enter_mobile_number(String string) {
		myp.enter_mobile_number(string);
	}
	@Then("Enter address {string}")
	public void enter_address(String string) {
		myp.enter_address(string);
	}
	@Then("Select region Dhaka")
	public void select_region_dhaka() {
		myp.select_region_dhaka();
	}
	@Then("Select town Dhaka")
	public void select_town_dhaka() {
		myp.select_town_dhaka();
	}
	@Then("Click on save button")
	public void click_on_save_button() {
		myp.click_on_save_button();
	}
//=====================================================================================================		
	
	
	
	
	
//=====================================================================================================	
	@Then("Click on driving licence")
	public void click_on_driving_licence() throws IOException {
	   myp.click_on_driving_licence();
	}
	@Then("CLick on add now button")
	public void c_lick_on_add_now_button() {
	    myp.c_lick_on_add_now_button();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
