package GB_APP.Utility;
/**
 * 
 * @author Prathmesh.Mahure
 * 
 */
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.common.io.Files;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import net.bytebuddy.utility.RandomString;

public class BaseTest extends ConfigeDataProvider {
	
	static String userName= "randhir.kumarheromotocorp";
	static String accessKey= "bduH44LqYpsKBB4XN6tTZLzuIoczCKiqbpWCzsmpuRnFjPsnud";

//	@BeforeTest(alwaysRun = true)
//	@BeforeAll
	public static void configureApp() throws Exception  {
		deleteAllureReportFolder();  // delete folder if exists every time execution starts
		GB_APP.Utility.Log.initialiseExtentReport(LOGGER);
		LOGGER.debug("====================================================================================");
		LOGGER.debug("   *********************   Launching Hero GB UI Test App    ******************");
		LOGGER.debug("====================================================================================");
		launchApp(Platform_name);
		System.out.println("Session ID:" + driver.getSessionId());
	}
	
//	@BeforeClass(alwaysRun = true)
	public void beforeClass()  {
		
	}
	
	@SuppressWarnings("static-access")
//	@BeforeMethod(alwaysRun = true)
	public static void beforeMethod( Scenario method ) {
		GB_APP.Utility.Log.extentLogger = Log.extent.createTest(method.getName());
		Allure.getLifecycle().updateTestCase(tc -> tc.setName(method.getName()));	
//		Log.extentLogger = Log.extent.createTest(result.getTestClass().getName() + "=" +method.getName());
		LOGGER.debug("====================================================================================");
		LOGGER.debug("====================================================================================");
		LOGGER.debug("                   Start -> Test -> " + method.getName() + "    ");
		LOGGER.debug("                   ===============================================");
	}

//	@AfterMethod(alwaysRun = true)
	public void afterMethod(Scenario method) throws Exception  {
		GB_APP.Utility.Log.afterMethodLogResultBDD(method, driver);
//		addScreenshot(method);
//		LOGGER.debug(" 1");
//		Library.threadSleep(1000);
//		LOGGER.debug(" End -> Test -> " + method.getName() + "    ");
//		LOGGER.debug("====================================================================================");
	}
//	@AfterClass(alwaysRun = true)
	public void afterClass()  {
		LOGGER.debug("====================================================================================");
		LOGGER.debug("====================================================================================");
		LOGGER.debug("*******************        Next Class suite      ***********************");
		LOGGER.debug("====================================================================================");
//		reloadBrowser();
	}

//	@AfterTest(alwaysRun = true)
//	@AfterAll
	public static void tearDown() {
		LOGGER.debug("====================================================================================");
		LOGGER.debug("====================================================================================");
		LOGGER.debug("*******************         Driver Quit       ***********************");
		LOGGER.debug("====================================================================================");
		GB_APP.Utility.Log.flushExtent(LOGGER);
		driver.quit();
	
	}
//=========================================================================================================================
//=========================================================================================================================
//=========================================================================================================================
	public static void launchApp(String Platform_name) throws MalformedURLException {
		URL url = null;
		DesiredCapabilities caps;
		
		switch (Platform_name) {
		case "emulator":
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, EmulatorDeviceName);
			caps.setCapability(MobileCapabilityType.APP, UserDirectoryPath + AppPath);
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("appium:udid", "emulator-5554");// 0836731257071990 //emulator-5554 //0526532038000424
			caps.setCapability("appium:avd", EmulatorDeviceName);// if u connect real device comment this line
			caps.setCapability("appium:avdLaunchTimeout", 600000);
			caps.setCapability("newCommandTimeout", 1200);
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("appPackage", "com.hero.gbcustomer");               
			caps.setCapability("appActivity", "com.hero.gbcustomer.views.activity.MainActivity"); 
			caps.setCapability("appium:noReset", "false");
			

				url = new URL(Url);
				driver = new AndroidDriver(url, caps);
			break;

		case "realdevice":
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix");
//			caps.setCapability(MobileCapabilityType.APP, UserDirectoryPath + AppPath);
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("appium:udid", RealDeviceName);// 0836731257071990 //emulator-5554 //0526532038000424
			caps.setCapability("appium:avdLaunchTimeout", 600000);
			caps.setCapability("newCommandTimeout", 1200);
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("appPackage", "com.hero.gbcustomer");               
			caps.setCapability("appActivity", "com.hero.gbcustomer.views.activity.MainActivity"); 
			caps.setCapability("appium:noReset", "false");
			try {
				url = new URL(Url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Real device issue");
			}
			driver = new AndroidDriver(url, caps);
			break;
			
		case "pcloudy":
			
			
			try {
				////   Lambda Start code  part =============
               caps = new DesiredCapabilities();
              HashMap<String, Object> ltOptions = new HashMap<String, Object>();
              ltOptions.put("w3c", true);
              ltOptions.put("platformName", "android");
              ltOptions.put("deviceName", "Pixel.*");
              ltOptions.put("platformVersion", "1[234]");
              ltOptions.put("app", "lt://APP10160502001723537798506439");
              ltOptions.put("devicelog", true);
              ltOptions.put("visual", true);
              ltOptions.put("video", true);
              ltOptions.put("console", true);
              ltOptions.put("isRealMobile", true);
              ltOptions.put("autoGrantPermissions", true);     // for permission
              ltOptions.put("unicodeKeyboard", true);
              ltOptions.put("resetKeyboard", true);
              ltOptions.put("noReset", false);
              ltOptions.put("appiumVersion", "2.0.0");//
              ltOptions.put("project_Name", "GB App");
              ltOptions.put("build", "2.4");
              ltOptions.put("name", "GB App");
              caps.setCapability("lt:options", ltOptions);
              driver = new AndroidDriver(
                      new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
                      caps);
//             driver.activateApp("com.hero.gbcustomer");	
//              ((JavascriptExecutor) driver).executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"This is a sample remark for failed test \"}} ");	
				
				///   Lambda end code  part =============
				
				
              ////   Pcloudy Start code  part =============
//			caps = new DesiredCapabilities();
//			caps.setCapability("pCloudy_Username", "randhir.kumar@heromotocorp.com");
//			caps.setCapability("pCloudy_ApiKey", "2gdc5pv55mh54mqtwmvj4xbr");
//			caps.setCapability("pCloudy_DurationInMinutes", 60);
//			caps.setCapability("newCommandTimeout", 600);
//			caps.setCapability("launchTimeout", 90000);
//			caps.setCapability("pCloudy_DeviceManufacturer", pCloudy_DeviceManufacturer);
//			caps.setCapability("pCloudy_DeviceVersion",pCloudy_DeviceVersion);
//			caps.setCapability("platformVersion", pCloudy_DeviceVersion);
//// 		    caps.setCapability("pCloudy_DeviceFullName", "SAMSUNG_GalaxyS22Ultra_Android_13.0.0_b9cf0");					
//			caps.setCapability("platformName", "Android");
//			caps.setCapability("automationName", "uiautomator2");						 
//			caps.setCapability("pCloudy_ApplicationName", "dev_app.apk"); //freedo					 
//			caps.setCapability("appPackage", "com.hero.gbcustomer");
//			caps.setCapability("appActivity", "com.hero.gbcustomer.views.activity.MainActivity");
//			caps.setCapability("unicodeKeyboard", true);
//			caps.setCapability("resetKeyboard", true);
//			caps.setCapability("pCloudy_WildNet", true);
//			caps.setCapability("pCloudy_EnableVideo", true);
//			caps.setCapability("pCloudy_EnablePerformanceData", true);
//			caps.setCapability("pCloudy_EnableDeviceLogs", true); 
//		//	caps.setCapability("autoGrantPermissions", true);
//		//  driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), caps);
//			url = new URL("https://device.pcloudy.com/appiumcloud/wd/hub");
//			
//			driver = new AndroidDriver(url, caps);
              ////   Pcloudy end code  part =============
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.out.println("Pcloudy device issue");
			}
			
			break;	

		default:
			caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, EmulatorDeviceName);
			caps.setCapability(MobileCapabilityType.APP, UserDirectoryPath + AppPath);
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);
			caps.setCapability("newCommandTimeout", 600);
			try {
				url = new URL(Url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver = new AndroidDriver(url, caps);
			break;
		}

		Library.threadSleep(3000);

	}

//=========================================================================================================================
	public static void launchBrowser() throws  Exception {		
		
		String browser = ConfigeDataProvider.browser;
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
				ChromeOptions co = new ChromeOptions();			
				HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
				HashMap<String, Object> profile = new HashMap<String, Object>(); 
				HashMap<String, Object> prefs = new HashMap<String, Object>();
	
				contentSettings.put("notifications", 2);// 0 is ask  , 1 is allow , 2 is block
				contentSettings.put("geolocation", 1);
				contentSettings.put("media_stream", 1);
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				co.setExperimentalOption("prefs", prefs);				
				co.addArguments("--remote-allow-origins=*");
		    	co.addArguments("--disable-blink-features=AutomationControlled");
		    	co.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		    	co.addArguments("--incognito");
				co.addArguments("disable-infobars");
				co.addArguments("disable-extensions");
				co.addArguments("disable-gpu");
				co.addArguments("disable-dev-shm-usage");
				co.addArguments("no-sandbox");
				co.addArguments("disable-notifications");
		    	co.addArguments("--force-device-scale-factor=0.9");
		    	webDriver = new ChromeDriver(co);		
	//	    	driver.get(hero_hub_url);	
		    	webDriver.manage().window().maximize();	
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			break;
		default:
			webDriver = null;
			break;

		}
		Library.passmsg("BaseTest -> launchBrowser() -> Browser launched successfully");
		
	}	
//	co.addArguments("--headless");   //   Hiding chrome browser
//	co.addArguments("start-maximized");
//=========================================================================================================================
	public static void quitBrowser() {
		Library.threadSleep(1000);
		driver.quit();
	}	
//=========================================================================================================================
	public static void reloadBrowser() {
		driver.get(hero_hub_url);
	}	
//=========================================== Screenshot area ==============================================================================
	public static String getscreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver ;
		return ts.getScreenshotAs(OutputType.BASE64);	
	}
//=========================================================================================================================	
	public static String takeScreenshot() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy-hhmmss");
		String strDate = formatter.format(date);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//Reports//ChromeTestScreenShots//"+strDate +"_"+ RandomString.make(5) +"_" + ".jpg";
		try {
			Files.copy(srcFile, new File(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}
//=========================================================================================================================	
//	@AfterStep add screenshot to scenario
	public static void addScreenshot(Scenario scenario){

		if (scenario.isFailed()) {
		    String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		    byte[] screenshot = java.util.Base64.getDecoder().decode(screenshotBase64);
		    scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
	}
//=========================================================================================================================		
	  @SuppressWarnings({ "deprecation", "static-access" })
	   public static void HomePageActivity()  {
		   
		   try {
			   Activity activity = new Activity("com.hero.gbcustomer", "com.hero.gbcustomer.views.activity.HmcDashboardActivity");
	       activity.setStopApp(false);
	       ((AndroidDriver) driver).startActivity(activity);
	  //     Log.info("GB app activity start");
		   }
		   catch(Exception e) {
		//	   Log.error("Unable to start GB app activity");
		   		}
	   		}   
//=========================================================================================================================	
	public static void deleteAllureReportFolder() {
			try {
	        File reportFolder = new File("allure-results");
	        if (reportFolder.exists()) {
	            for (File file : reportFolder.listFiles()) {
	                file.delete();
	            }
	            reportFolder.delete();
//	            System.out.println(" Allure Report Folder deleted successfully");
	        }else {
	        	System.out.println(" Folder does not exist");
	        }
			}catch(Exception e) {
				System.out.println(" Unable to delete Allure Report Folder"+e.getMessage());
			}
	    }
//=========================================================================================================================		
		
		
	
}
