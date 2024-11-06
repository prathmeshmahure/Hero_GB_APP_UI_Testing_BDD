package GB_APP.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GB_APP.Utility.Library;
import io.appium.java_client.android.AndroidDriver;

public class DocumentPage extends BasePage{
	
	public DocumentPage(AndroidDriver driver) {
		super(driver);
	}
	

//=================================================================================================================	
	@FindBy(id = "com.hero.gbcustomer:id/tv1")
	private WebElement Document_Button;
	
	@FindBy(id="com.hero.gbcustomer:id/forwardIcon")
	private WebElement RCButton;
	
	@FindBy(id="com.hero.gbcustomer:id/forwardIcon2")
	private WebElement InsuranceButton;
	
	@FindBy(id="com.hero.gbcustomer:id/forwardIcon3")
	private WebElement PUCButton;
	
	@FindBy(id="com.hero.gbcustomer:id/forwardIcon4")
	private WebElement OtherButton;
	
	@FindBy(id="com.hero.gbcustomer:id/validity")
	private WebElement Validity;
	
	@FindBy(id="com.hero.gbcustomer:id/back_btn")
	private WebElement BackPageButton;
	
	@FindBy(id="com.hero.gbcustomer:id/cross_btn")
	private WebElement ClosePopupButton;
	
	@FindBy(id="com.hero.gbcustomer:id/back_btn")//pending id
	private WebElement ThreeDotButton;
	
	@FindBy(id="com.hero.gbcustomer:id/back_btn")//pending id
	private WebElement UploadNewButton;
	
	@FindBy(id="com.hero.gbcustomer:id/back_btn")//pending id
	private WebElement ShareButton;
	
	@FindBy(id="com.hero.gbcustomer:id/back_btn")//pending id
	private WebElement DownloadButton;
	
//	@FindBy(id="com.hero.gbcustomer:id/back_btn")
//	private WebElement BackPageBu;
//	
//	@FindBy(id="com.hero.gbcustomer:id/back_btn")
//	private WebElement BackPageBu;
//	
//	@FindBy(id="com.hero.gbcustomer:id/back_btn")
//	private WebElement BackPageBu;
	
//	@FindBy(xpath="//android.widget.TextView[@text='My Profile']")
//	private WebElement Insurton;
//	
//	@FindBy(xpath="//android.widget.TextView[@text='More details']")
//	private WebElement MoreDetails;

	
			
	
	

//============================================================================================================	
//============================================================================================================
//============================================================================================================
//============================================================================================================
	public void user_click_on_document_button() {
		Library.click(driver, Document_Button, "Document Button");
		
	}
	public void click_on_registration_button() {
		Library.click(driver, RCButton, "RC Button");
		
	}
	public void verify_validity_date() {
		Library.visible_link_gettext(driver, Validity, "Expiry date");
		
	}
	public void click_on_back_page_button() {
		Library.click(driver, BackPageButton, "Back page Button");
		
	}
	public void click_on_back_document_button() {
		Library.click(driver, BackPageButton, "Back document Button");
		
	}
	public void click_on_insurance_button() {
		Library.click(driver, InsuranceButton, "Insurance Button");
		
	}
	public void click_on_puc_button() {
		Library.click(driver, PUCButton, "PUC Button");
		
	}
	public void click_on_other_button() {
		Library.click(driver, OtherButton, "Other Button");
		
	}
	public void click_on_three_dot_button() {
		Library.click(driver, ThreeDotButton, "Three Dot Button");
		
	}
	public void click_on_upload_new_button() {
		Library.click(driver, UploadNewButton, "Upload New Button");
		
	}
	public void click_on_close_popup_icon() {
		Library.click(driver, ClosePopupButton, "Close Popup Button");
		
	}
	public void click_on_share_button() {
		Library.click(driver, ShareButton, "Share Button");
		
	}
	public void click_on_android_back_button() {
		Library.Back_button(driver);
		
	}
	public void click_on_download_button() {
		Library.click(driver, DownloadButton, "Download Button");
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
