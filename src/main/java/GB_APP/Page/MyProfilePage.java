package GB_APP.Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GB_APP.Utility.BaseTest;
import GB_APP.Utility.Library;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyProfilePage extends BasePage{

	public MyProfilePage(AndroidDriver driver) {
		super(driver);
	}

	
//=================================================================================================================	
	@FindBy(id = "com.hero.gbcustomer:id/ivHome")
	private WebElement Home_Button;
	
	@FindBy(id="com.hero.gbcustomer:id/side_menu_btn")
	private WebElement MenuIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='My Profile']")
	private WebElement MyProfile;
	
	@FindBy(xpath="//android.widget.TextView[@text='More details']")
	private WebElement MoreDetails;
	
	@FindBy(xpath="//android.widget.TextView[@text='Edit Profile Details']")
	private WebElement EditProfileDetails;
	
	@FindBy(xpath="(//android.widget.EditText[@resource-id='com.hero.gbcustomer:id/text_input_editext'])[1]")
	private WebElement EnterFullName;
	
	@FindBy(xpath="(//android.widget.EditText[@resource-id='com.hero.gbcustomer:id/text_input_editext'])[2]")
	private WebElement EnterEmailId;
	
	@FindBy(xpath="(//android.widget.EditText[@resource-id='com.hero.gbcustomer:id/numberEditfield'])[1]")
	private WebElement EnterMobileNumber;
	
	@FindBy(xpath="(//android.widget.EditText[@resource-id='com.hero.gbcustomer:id/text_input_editext'])[4]")
	private WebElement EnterAddress;
	
	@FindBy(xpath="(//android.widget.Spinner[@resource-id='com.hero.gbcustomer:id/filled_exposed'])[1]")
	private WebElement SelectRegion;
	
	@FindBy(xpath="(//android.widget.Spinner[@resource-id='com.hero.gbcustomer:id/filled_exposed'])[2]")
	private WebElement SelectTown;
	
	@FindBy(xpath="//android.widget.TextView[@text='Save']")
	private WebElement SaveButton;

//	@FindBy(xpath = "//android.widget.TextView[@text='Continue']")
//	private WebElement ContinueButton;
//
//	@FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.hero.gbcustomer:id/checkbox'])[2]")
//	private WebElement selectLanguage;
//		
//	@FindBy(id = "com.hero.gbcustomer:id/userEmailPhone")
//	private WebElement EnterEmail;
//	
//	@FindBy(xpath = "(//android.widget.EditText[@text='-'])[1]")
//	private WebElement EnterOtp;
//	
//	@FindBy(id = "com.hero.gbcustomer:id/otp_one_edtxt")
//	private WebElement EnterPassword1;
//	
//	@FindBy(id = "com.hero.gbcustomer:id/permission_allow_lbl")
//	private WebElement ClickAllowButton;
//	
//	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
//	private WebElement ClickWhileUsingApp;
//	
//	@FindBy(id = "com.hero.gbcustomer:id/btn_lbl")
//	private WebElement ClickProceedButton;
//	
//	@FindBy(xpath = "//android.widget.TextView[@text='Verify']")
//	private WebElement VerifyButton;
//	
//	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.hero.gbcustomer:id/title']")
//	private List<WebElement> AllCountry;
//	
//	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.hero.gbcustomer:id/title']")
//	private List<WebElement> AllLanguage;
//	
//	@FindBy(xpath = "//android.widget.TextView[@text='Turkish']")
//	private WebElement TurkishLanguage;
	
	
	
//============================================================================================================	
//============================================================================================================
//============================================================================================================
//============================================================================================================
	public void click_on_at_home_page_icon_button() {
		
		BaseTest.HomePageActivity();
		Library.click(driver, Home_Button, "Home button");
	}
	public void user_click_on_menu_icon() {
		
		Library.click(driver, MenuIcon, "Menu Icon");
	}
	public void click_on_my_profile() {
		
		Library.click(driver, MyProfile, "My Profile");
	}
	public void click_on_more_details() {
		
		Library.click(driver, MoreDetails, "More Details");
	}
	public void click_on_edit_profile_details() {
		
		Library.click(driver, EditProfileDetails, "Edit Profile Details");
	}
	public void enter_full_name(String string) {
		
		Library.sendKeys(driver, EnterFullName, string, string);
	}
	public void enter_email_id(String string) {
		
		Library.sendKeys(driver, EnterEmailId, string, string);
	}
	public void enter_mobile_number(String string) {
		
		Library.sendKeys(driver, EnterMobileNumber, string, string);
	}
	public void enter_address(String string) {
		
		Library.customScrollTillElementDisplay(driver, SaveButton);
		Library.sendKeys(driver, EnterAddress, string, string);
	}
	public void select_region_dhaka() {
		
		Library.click(driver, SelectRegion, "Select Region");
		Library.click(driver, SelectRegion, "Dhaka");
	}
	public void select_town_dhaka() {
		
		Library.click(driver, SelectTown, "Select Town");
		Library.click(driver, SelectTown, "Dhaka");
	}
	public void click_on_save_button() {
		
		Library.click(driver, SaveButton, "SaveButton");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//====================================== Upload file code is working fine=================================================================	
	public void click_on_driving_licence() throws IOException {
		
		// Path to the PDF file on your local machine
        String jpgFilePath = System.getProperty("user.dir") + "//src//test//resources//Pdf_file//license.jpg";
        // Convert the file to a byte array
        byte[] fileContent = Files.readAllBytes(Paths.get(jpgFilePath));

        // Push the file to the emulator's file system
        driver.pushFile("//storage//emulated//0//Download//license.jpg", fileContent);
        Library.passmsg("File pushed successfully");

	}
	public void c_lick_on_add_now_button() {
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
