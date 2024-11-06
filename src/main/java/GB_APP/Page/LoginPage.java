package GB_APP.Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import GB_APP.Utility.BaseTest;
import GB_APP.Utility.ConfigeDataProvider;
import GB_APP.Utility.Library;
import GB_APP.Utility.Log;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends BasePage{

	public LoginPage(AndroidDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement AllowPermission;
	
	@FindBy(xpath="//android.widget.TextView[@text='Bangladesh']//following-sibling::android.widget.ImageView")
	private WebElement SelectBangladesh;
	
	@FindBy(xpath="//android.widget.TextView[@text='India']")
	private WebElement SelectIndia;

	@FindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private WebElement ContinueButton;

	@FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.hero.gbcustomer:id/checkbox'])[2]")
	private WebElement selectLanguage;
		
	@FindBy(id = "com.hero.gbcustomer:id/userEmailPhone")
	private WebElement EnterEmail;
	
	@FindBy(xpath = "(//android.widget.EditText[@text='-'])[1]")
	private WebElement EnterOtp;
	
	@FindBy(id = "com.hero.gbcustomer:id/otp_one_edtxt")
	private WebElement EnterPassword1;
	
	@FindBy(id = "com.hero.gbcustomer:id/permission_allow_lbl")
	private WebElement ClickAllowButton;
	
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement ClickWhileUsingApp;
	
	@FindBy(id = "com.hero.gbcustomer:id/btn_lbl")
	private WebElement ClickProceedButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement VerifyButton;

	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.hero.gbcustomer:id/title']")
	private List<WebElement> AllCountry;
	
	@FindBy(id = "com.hero.gbcustomer:id/itemRow")
	private WebElement CountryScrollBox;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.hero.gbcustomer:id/title']")
	private List<WebElement> AllLanguage;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Turkish']")
	private WebElement TurkishLanguage;
	
	
	
//============================================================================================================	
//============================================================================================================
//============================================================================================================
//============================================================================================================
	
	public void user_launch_successfully_application() {
		Library.visible_link(driver, AllowPermission, "Launch browser Successfully");
	}
	
	public void user_allow_permission() {
		Library.click(driver, AllowPermission, "Allow Permission");
	}
	
	public void user_select_country() {
    	Library.click(driver, SelectBangladesh, "Select Bangladesh");
	}
	
	public void user_select_language() {
		Library.click(driver, selectLanguage, "Select Language");
	}
	
	public void user_enters_email_as(String string) {
		Library.sendKeys(driver, EnterEmail,string, "Email Address");
	}
	
	public void click_on_continue_button() {
		Library.click(driver, ContinueButton, "Continue Button");
	}
	
	public void user_enters_password_as(String string) {		
		Library.threadSleep(5000);
		Library.waitForVisibilityOfTenSeconds(driver, VerifyButton);
		Library.waitForVisibilityOfTenSeconds(driver, EnterPassword1);
			if(EnterPassword1.isDisplayed()) {
				EnterPassword1.click();
				Library.EnterOtp(driver);
				Library.passmsg("OTP is successfully entered ="+string);
			}else {
			Library.failmsg("OTP filed is not displayed ="+string);	
			}
	}
	
	public void click_on_verify_button() {
		Library.click(driver, VerifyButton, "Verify Button");
	}
	public void click_on_allow_permission_button() {
	   Library.click(driver, ClickAllowButton, "Allow Button");
	}
	public void click_on_while_using_the_app() {
	   Library.click(driver, ClickWhileUsingApp, "While using the app");
	}
	public void click_on_proceed_button() {
		Library.click(driver, ClickProceedButton, "Proceed Button"); 
	}
	@SuppressWarnings("deprecation")
	public void close_app() {
//		driver.close();
//		driver.quit();
		driver.resetApp();
		Library.passmsg("App closed");
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	public void all_country_should_be_displayed() {
		try {        
	        Set<String> countryNames = new HashSet<>();
	        boolean canScrollMore = true;
	        while (canScrollMore) {
				            for (WebElement AllCountry1 : AllCountry) {
				                countryNames.add(AllCountry1.getText());
				            }
					        try {    canScrollMore = SelectIndia.isDisplayed()==false;  }catch(Exception e) {
					            Library.horizontal_scroll_by_pixel(driver, AllCountry.get(0), AllCountry.get(2), "Page Scrolling");

					        }
	        		}
	        // Print all unique country names
	        for (String country : countryNames) {
	        	Library.passmsg("Visible Country Name = "+country);
	        }
	
	    } catch (Exception e) {    }	
	}
//====================================================================================================================	
	public void all_language_should_be_displayed() {
		try {        
	        Set<String> language = new HashSet<>();
	        boolean canScrollMore = true;
	        while (canScrollMore) {
				            for (WebElement Alllanguage : AllLanguage) {
				            	language.add(Alllanguage.getText());
				            }
					        try {    canScrollMore = TurkishLanguage.isDisplayed()==false;  }catch(Exception e) {
					            Library.horizontal_scroll_by_pixel(driver, AllLanguage.get(0), AllLanguage.get(2), "Page Scrolling");
					        }
	        		}
	        // Print all unique country names
	        for (String languages : language) {
	        	Library.passmsg("Visible Language = "+languages);
	        }
	    } catch (Exception e) {    }	
	}	
//====================================================================================================================	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
