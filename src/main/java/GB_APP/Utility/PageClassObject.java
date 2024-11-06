package GB_APP.Utility;

/**
 * @author Prathmesh.Mahure
 * 
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import GB_APP.ExcelDataProvider.excelTestData;
import GB_APP.Page.DocumentPage;
import GB_APP.Page.LoginPage;
import GB_APP.Page.MyProfilePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class PageClassObject {

	public static AppiumDriverLocalService service;
	public static Logger LOGGER = LogManager.getLogger("Log");
	public static Log log;
	public static AndroidDriver driver;
	public static WebDriver webDriver;
	public static excelTestData exceldata;
	public static LoginPage loginPg;
	public static MyProfilePage myp;
	public static DocumentPage DP;
	
//	@BeforeMethod(alwaysRun = true)
	public static void getObject() {

		exceldata = new excelTestData();
		log = new Log();
		loginPg = new LoginPage(driver);
		myp = new MyProfilePage(driver);
		DP = new DocumentPage(driver);
		
		
		
		
	}

}
