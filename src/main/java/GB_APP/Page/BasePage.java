package GB_APP.Page;


import org.openqa.selenium.support.PageFactory;

import GB_APP.Utility.PageClassObject;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Prathmesh.Mahure
 *
 */

public abstract class BasePage extends PageClassObject {

	public static AndroidDriver driver;

	@SuppressWarnings("static-access")
	public BasePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
