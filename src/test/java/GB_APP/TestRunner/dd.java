package GB_APP.TestRunner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class dd {
    public static void main(String[] args) throws Exception {
        // Define the App Center download link
        String appCenterUrl = "https://install.appcenter.ms/orgs/heromobility/apps/gb-one-app-android/distribution_groups/navigation-india";

        // Download the APK file
        File apkFile = downloadFile(appCenterUrl, "downloaded_app.apk");

        // Set up DesiredCapabilities for Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        // Initialize the Appium driver
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, capabilities);

        // Wait for the app to launch
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Your test code here...

        // Quit the driver
        driver.quit();
    }

    private static File downloadFile(String fileUrl, String fileName) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(fileUrl);
        CloseableHttpResponse response = httpClient.execute(request);
        InputStream inputStream = response.getEntity().getContent();
        File downloadedFile = Paths.get(System.getProperty("java.io.tmpdir"), fileName).toFile();
        FileUtils.copyInputStreamToFile(inputStream, downloadedFile);
        response.close();
        return downloadedFile;
    }
    
    
    
    
    
    
    
    
//			    DesiredCapabilities capabilities = new DesiredCapabilities();
//			    capabilities.setCapability("pCloudy_Username", "randhir.kumar@heromotocorp.com");
//			    capabilities.setCapability("pCloudy_ApiKey", "2gdc5pv55mh54mqtwmvj4xbr");
//			    capabilities.setCapability("pCloudy_DurationInMinutes", 60);
//			    capabilities.setCapability("newCommandTimeout", 600);
//			    capabilities.setCapability("launchTimeout", 90000);
//			    capabilities.setCapability("pCloudy_DeviceFullName", "ONEPLUS_7Pro_Android_12.0.0_9a83e");
//			    capabilities.setCapability("platformVersion", "12.0.0");
//			    capabilities.setCapability("platformName", "Android");
//			    capabilities.setCapability("automationName", "uiautomator2");
//			    capabilities.setCapability("pCloudy_ApplicationName", "dev_app.apk");
//			    capabilities.setCapability("appPackage", "com.hero.gbcustomer");
//			    capabilities.setCapability("appActivity", "com.hero.gbcustomer.views.activity.MainActivity");
//			    capabilities.setCapability("pCloudy_WildNet", false);
//			    capabilities.setCapability("pCloudy_EnableVideo", false);
//			    capabilities.setCapability("pCloudy_EnablePerformanceData", false);
//			    capabilities.setCapability("pCloudy_EnableDeviceLogs", false);
//			    capabilities.setCapability("appiumVersion", "1.22.0");
//			    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
			    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
