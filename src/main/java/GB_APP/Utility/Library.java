package GB_APP.Utility;

/**
 * 
 * @author Prathmesh.Mahure
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Library  {
	
//=============================================================================================
	public static void click( WebDriver driver,WebElement element, String LogMessege)  {
		try {
			waitForVisibilityOf(driver, element);
			element.click();
			Log.info("Element is clickable : " + LogMessege);
		} catch (Exception e) {		
			Log.error("Unable to click element : " + LogMessege + "  --  " + element);
			Assert.assertTrue(false, "Unable to click element : " + LogMessege + "  --  " + element);
		}
	}
//=============================================================================================
	public static void sendKeys(WebDriver driver, WebElement element, String enterValue, String LogMessege) {
		try {
			waitForVisibilityOf(driver ,element);
			element.click();
			element.clear();
			element.sendKeys(enterValue);
			Log.info("Value send Successfully : " + LogMessege);
		} catch (Exception e) {
			Log.error("Unable to send value  : " + LogMessege + " : "  + element);
			Assert.assertTrue(false, "Unable to send value  : " + LogMessege + " : "  + element );
		}
	}
//=============================================================================================	
		public static void visible_link(WebDriver driver,WebElement element,String LogMessege) {
					
			try {
				waitForVisibilityOf(driver, element);
				if(element.isDisplayed()) { 
				Log.info("Field is visible  : "+LogMessege);
				}
		}
		catch(Exception e) {
			Log.error("Unable to visible field  : " + LogMessege + "  --  " + element);
			Assert.assertTrue(false, "Unable to visible field  : " + LogMessege + "  --  " + element );
		}
	}
//=============================================================================================	
		public static void visible_link_gettext(WebDriver driver,WebElement element, String fieldname) {
			try {
				waitForVisibilityOf( driver,element);
				if(element.isEnabled() || element.isDisplayed()==true) {
					String text=element.getText();		
				Log.info("Field is visible : "+fieldname+" : "+text);
				}
			}
			catch(Exception e) {
				
					Log.error("Unable to visible field : "+fieldname);		
					Assert.assertTrue(false, "Unable to visible field : "+fieldname );
					}
			
		}		
//=============================================================================================	
	public static WebElement waitForVisibilityOf(WebDriver driver, WebElement element) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			//Log.error("Unable to visible field  : " +"  --  " + element);
		}
		return element;
	}
	public static WebElement waitForVisibilityOfTenSeconds(WebDriver driver, WebElement element) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			//Log.error("Unable to visible field  : " +"  --  " + element);
		}
		return element;
	}
//=============================================================================================
	public static void threadSleep(int MiliSeconds) {
		try {
			Thread.sleep(MiliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//=============================================================================================
	public static String getStringConfigData(String key) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Config_Data//prod_config.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String PostURL = prop.getProperty(key);
		return PostURL;
	}
//=============================================================================================
	public static int getNumericConfigData(String key) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Config_Data//prod_config.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String KeyValue = prop.getProperty(key);
		int intKeyValue = Integer.parseInt(KeyValue);
		return intKeyValue;
	}
//=============================================================================================
	public static String getExcelData(int SheetNumber, int RowNumber, int ColumnNumber) {
		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//ExcelTestData.xlsx";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String TestData = wb.getSheetAt(SheetNumber).getRow(RowNumber).getCell(ColumnNumber).getStringCellValue();
			return TestData;
		} catch (Exception e) {
			double TestData_InDouble = wb.getSheetAt(SheetNumber).getRow(RowNumber).getCell(ColumnNumber)
					.getNumericCellValue();
			String TestData = String.valueOf(TestData_InDouble);
			String TestDataAr[] = TestData.split("\\.");
			return TestDataAr[0];
		}
	} 
//=================================================================================================================================	    
	   public static void isDisplayed(WebDriver driver, WebElement ele, String Element_name) {
			try {
				waitForVisibilityOf( driver, ele);
				if(ele.isDisplayed()==true) {				
					Log.info(Element_name+":  Displayed");
				   }
				}
			catch(Exception e) {					
					Log.error(Element_name+":  Not Displayed"+e);					
					}
		}	   
//=================================================================================================================================	   
	   public static void assertEquals(WebDriver driver, WebElement ele, String Expected_value) {
			try {	
				waitForVisibilityOf(driver, ele);
				String Actual_value =ele.getText();
				if(Actual_value.equalsIgnoreCase(Expected_value)) {				
					Log.info( Expected_value+ ":  Expected value is Match");
				   }
				Log.error(Expected_value +":  Expected value is not Match");
				}
			catch(Exception e) {					
					Log.error(Expected_value +":  Expected value is not Match"+e);					
					}
		}		   
//=================================================================================================================================	   
	   public static void assertEquals(WebDriver driver,String Actual_value, String Expected_value) {
			try {	
				
				if(Actual_value.equalsIgnoreCase(Expected_value)) {				
					Log.info( "Actual value "+ ":  Expected value is Match");
				   }
				Log.error(Expected_value +":  Expected value is not Match");
				}
			catch(Exception e) {					
					Log.error(Expected_value +":  Expected value is not Match"+e);					
					}
		}	   
//=================================================================================================================================
	   public static void scrollwebpage(WebDriver driver, WebElement element,String message) {
			try {
			waitForVisibilityOf(driver, element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			}catch(Exception e) {
				System.out.println("Unable to scroll element"+message);
			}
		}    	 		   
//=================================================================================================================================
	public static void passmsg(String string) {
		
		Log.info( string );
	}
//=================================================================================================================================
	public static void failmsg(String string) {
		
		Log.error( string );
	}
//=================================================================================================================================
	public static void EnterOtp(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
	} 
	public static void Back_button(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Log.info("Back Button Pressed");
	} 
//======================================================================================================
	public static void scrollDownTillElementDisplayByText(AndroidDriver driver, String text) {
		try {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
			Log.info("scrollTillElement : " + text);
		} catch (Exception e) {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
			Log.info("unable to scrollTillElement : " + text);
		}
	}
//=============================================================================================
	@SuppressWarnings("deprecation")
	public static void scroll_particular_ElementDisplayByBox(AndroidDriver driver,String ResourceId, String text) {
		try {  // Using this method we can scroll till particular element But need scrollbox  resource id
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + ResourceId + "\")).scrollIntoView("
						    + "new UiSelector().text(\"" + text + "\"));"));
			Log.info("scrollTillElement : " + text);
		} catch (Exception e) {
			driver.findElement(MobileBy
					.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + ResourceId + "\")).scrollIntoView("
						    + "new UiSelector().text(\"" + text + "\"));"));
			Log.info("unable to scrollTillElement : " + text);			
		}
	}
//=============================================================================================
	@SuppressWarnings("deprecation")
	public static void customScrollTillElementDisplay(AndroidDriver driver, WebElement element) {
//		Log.info("customScrollTillElementDisplay");
		for (int i = 0; i <= 10; i++) {
			Library.threadSleep(1000);
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width = size.width;
			int height = size.height;
			int middleOfX = width / 2;
			int startYCoordinate = (int) (height * .7);
			int endYCoordinate = (int) (height * .5);
			action.press(PointOption.point(middleOfX, startYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();

			try {
				element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.print("");
			}
		}

	}
//=============================================================================================
	@SuppressWarnings("deprecation")
	public static void ScrollUpTillElementDisplay(AndroidDriver driver, WebElement element) {
//		Log.info("customScrollTillElementDisplay");
		for (int i = 0; i <= 10; i++) {
			Library.threadSleep(1000);
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width = size.width;
			int height = size.height;
			int middleOfX = width / 2;
			int startYCoordinate = (int) (height * .2);
			int endYCoordinate = (int) (height * .7);
			action.press(PointOption.point(middleOfX, startYCoordinate))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
					.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();

			try {
				element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.print("");
			}
		}

	}
//=============================================================================================
	@SuppressWarnings("deprecation")
	public static void scrollByOffset(AndroidDriver driver, int NoOfPagesScroll) {
		Log.info("Scrolling by offset : " + NoOfPagesScroll);
		for (int i = 0; i < NoOfPagesScroll; i++) {
			TouchAction action = new TouchAction(driver);
			Dimension size = driver.manage().window().getSize();
			int width = size.width;
			int height = size.height;
			int middleOfX = width / 2;
			int startYCoordinate = (int) (height * .7);
			int endYCoordinate = (int) (height * .2);
			try {
				action.press(PointOption.point(middleOfX, startYCoordinate))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
			} catch (Exception e) {
				Log.info("Unable to scroll");
				break;
			}

		}
	}	
//=============================================================================================
	public static void horizontal_scroll_by_pixel(WebDriver driver,WebElement end_position,WebElement Start_position ,String fieldname) {
	try {	waitForVisibilityOf( driver, end_position);waitForVisibilityOf( driver, Start_position);
	
		if(end_position.isDisplayed() || end_position.isEnabled() && Start_position.isDisplayed() || Start_position.isEnabled()==true) {
				
			Point location1=end_position.getLocation();
			Point location2=Start_position.getLocation();
			int end_x=location1.x;
			int end_y=location1.y;
			int start_x=location2.x;
			int start_y=location2.y;
			
			Library.swipe_page_direction((AndroidDriver) driver, start_x, start_y, end_x, end_y, "Page scroll");
//			for(int i=0;i<=3;i++) {
//				Library.swipe_page_direction((AndroidDriver) driver, start_x, start_y, end_x, end_y, "Page scroll");
//				}
			
			
///			Log.info("Successfully Scroll "+fieldname);
			}
	}
	catch(Exception e) {
	
//	Log.error("Unable To Scroll"+fieldname+e);		
	
	}
	} 
//=================================================================================================================================
	public static void Vertical_scroll_image(WebDriver driver,WebElement end_position,WebElement Start_position ,String fieldname) {
			try {	waitForVisibilityOf( driver, end_position);waitForVisibilityOf( driver, Start_position);
			
				if(end_position.isDisplayed() || end_position.isEnabled() && Start_position.isDisplayed() || Start_position.isEnabled()==true) {
						
					Point location1=end_position.getLocation();
					Point location2=Start_position.getLocation();
					int end_x=location1.x;
					int end_y=location1.y;
					int start_x=location2.x;
					int start_y=location2.y;
											
						Library.swipe_page_direction((AndroidDriver) driver, start_x, start_y, end_x, end_y, "Page scroll");
//					Log.info("Successfully Scroll "+fieldname);
					}
			}
			catch(Exception e) {
//			Log.error("Unable To Scroll"+fieldname);		
		
			}
			} 	    
	//=====================================================================================================
    @SuppressWarnings({ "deprecation", "rawtypes" })
	public static void Scroll_UP_page_Action(AndroidDriver driver,String fieldname) {  	
	    try {
	    	Dimension dim = driver.manage().window().getSize();	    	
	    	int startx = (int) (dim.width*0.5);
	    	int starty = (int) (dim.height*0.8);	    	
	    	int endx   =  (int) (dim.width*0.2);  	
	    	int endy   = (int) (dim.height*0.2);
	    	TouchAction action = new TouchAction(driver);
	    	for(int i=0;i<=1;i++) {
	    	action.press(PointOption.point(startx ,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx ,endy))
	    		.release().perform();
	    	}
	    		//	Log.info("Successfully  Scroll up page Action "+fieldname);
	    	
	    }catch(Exception e) {		    	
					//Log.error("==NOT==Unable To Scroll up page Action "+fieldname);
		}	    
    }
//======================================================================================================
    @SuppressWarnings("deprecation")
	public static void scrollByText(AndroidDriver driver,String menuText) {

    	 try {
    		 Thread.sleep(1000);
    	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + menuText + "\").instance(0));")); 
    	 } catch (Exception e) {
    		// Log.error("==NOT==Unable To Scroll By text "+menuText);
    	 }
     }
//======================================================================================================	    
    @SuppressWarnings({ "deprecation", "rawtypes" })
	public static void Scroll_down_page_Action(AndroidDriver driver,String fieldname) {  	
	    try {
	    	Dimension dim = driver.manage().window().getSize();	    	
	    	int startx = (int) (dim.width*0.5);
	    	int starty = (int) (dim.height*0.2);	    	
	    	int endx   =  (int) (dim.width*0.2);  	
	    	int endy   = (int) (dim.height*0.8);
	    	TouchAction action = new TouchAction(driver);
	    	for(int i=0;i<=1;i++) {
	    	action.press(PointOption.point(startx ,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx ,endy))
	    		.release().perform();
	    	}			    	
	    }catch(Exception e) {		    						
		}	    
    }
//======================================================================================================
    @SuppressWarnings({ "rawtypes", "deprecation" })
	public static void swipe_page_direction(AndroidDriver driver,int startx,int starty,int endx,int endy,String fieldname ) {
    	try {
    		TouchAction action = new TouchAction(driver);
    		action.press(PointOption.point(startx ,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx ,endy))
    		.release().perform();     
    	}catch(Exception e) {		    	
		}	
    }
//==================================================================================================================

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		    
}
