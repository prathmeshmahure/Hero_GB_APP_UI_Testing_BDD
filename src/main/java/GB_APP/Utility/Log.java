package GB_APP.Utility;

import java.io.ByteArrayInputStream;

/**
 * 
 *@author Prathmesh.Mahure
 * 
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import net.bytebuddy.utility.RandomString;

public class Log extends PageClassObject{
	
	public static ExtentReports extent;
	public static ExtentTest extentLogger; // helps to generate logs in extent test report
	public static ExtentSparkReporter reporter;
//	public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
	public static final Logger LOGGER = LogManager.getLogger("Log");
//=========================================================================================================================	
	public static void info(String message) {
	//	String LogMessege=Library.addSpaceBeforeUppercase(message);
		LOGGER.info(message);
		extentLogger.log(Status.PASS, message);	
		Allure.step(message);
	}
//=========================================================================================================================
	public static void debug(String message) {
		LOGGER.debug(message);
		extentLogger.log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.YELLOW));
		}
//=========================================================================================================================
	public static void warn(String message) {
		LOGGER.info(message);
		extentLogger.log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.YELLOW));
		Allure.step(message);
	}
//=========================================================================================================================
	public static void ChromeFocus() {
		extentLogger.addScreenCaptureFromPath(BaseTest.takeScreenshot()); // Imp ScreenShot		
	}
//=========================================================================================================================
	public static void AddScreenshot() {
		extentLogger.addScreenCaptureFromBase64String(BaseTest.getscreenshot());	
	}
//=========================================================================================================================
	public static void error(String message) {
		LOGGER.error(message);
			//		extentLogger.log(Status.FAIL, message);
		extentLogger.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));	
		extentLogger.addScreenCaptureFromBase64String(BaseTest.getscreenshot());
			//		BaseTest.takeScreenshot();
		captureScreenshot(message);    // allure report parts
		Allure.step(" Error -: "+message);
	}	
//=========================================================================================================================
	

	public static void initialiseExtentReport(Logger LOGGER) {
		LOGGER.debug("====================================================================================");
		LOGGER.debug("==========================      Configuring Extent Report      =====================");
		LOGGER.debug("====================================================================================");
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//ExtentReport.html");
//		((Object) reporter.config()).setChartVisibilityOnOpen(false);
		reporter.config().setDocumentTitle("Hero GB APP");
		reporter.config().setReportName("Hero GB APP Automation Report");
//		reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(Log.reporter);
		extent.setSystemInfo("Project Name", "Hero GB APP");
		extent.setSystemInfo("Platform", "Mobile");
		extent.setSystemInfo("Test Environment", "UAT");
		extent.setSystemInfo("Test Suite", "Regression Tests");
//		extent.setSystemInfo("Device", "Pixel 4");
		extent.setSystemInfo("Test Engineer", "Prathmesh Mahure");
	}
//=========================================================================================================================
	public static void flushExtent(Logger LOGGER) {
		LOGGER.debug("===================      Flushing Extent Report      ==============================");
		extent.flush();
	}
//=========================================================================================================================
	public static void afterMethodLogResultBDD(Scenario scenario, AndroidDriver driver) throws IOException {
		    if (scenario.isFailed()) {
		        extentLogger.log(Status.FAIL,
		                MarkupHelper.createLabel("TEST FAILED -- " + scenario.getName(), ExtentColor.RED));
		    } 
		    else if (scenario.getStatus().toString().equalsIgnoreCase("SUCCESS")) {
		        extentLogger.log(Status.PASS,
		                MarkupHelper.createLabel("TEST PASSED -- " + scenario.getName(), ExtentColor.GREEN));
		    } 
		    else if (scenario.getStatus().toString().equalsIgnoreCase("SKIPPED")) {
		        extentLogger.log(Status.SKIP,
		                MarkupHelper.createLabel("TEST SKIPPED -- " + scenario.getName(), ExtentColor.ORANGE));
		    } 
	    }
//=========================================================================================================================
	public static String takeScreenshot(String string, AndroidDriver driver) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy-hhmmss");
		String strDate = formatter.format(date);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//Reports//FailedTestScreenShots//"+strDate +"_"+ RandomString.make(2) +"_"+  string + ".jpg";
		try {
			Files.copy(srcFile, new File(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}
//=========================================================================================================================	

	public static void captureScreenshot(String screenshotName) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot = " + screenshotName, "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
	
	
	
}
