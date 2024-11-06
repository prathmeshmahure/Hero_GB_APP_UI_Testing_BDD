package GB_APP.StepDefinition;


import java.lang.reflect.Method;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import GB_APP.Utility.BaseTest;
import GB_APP.Utility.Log;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

/*Parent Class*/
public class BaseClass extends BaseTest{

	//generate unique email id
	public static String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	


	@BeforeAll
	public static void Configure() throws Exception
	{		
		configureApp();
	}
	@Before
	public static void Browser_Launch(Scenario Scenario) throws Exception
	{		
		beforeMethod(Scenario);
	}
	@BeforeStep
	public static void Before_Step() throws Exception
	{		
		getObject();
	}
	@AfterStep
	public  void After_Step(Scenario scenario) throws Exception
	{	
		addScreenshot(scenario);
	}
	@After
	public  void After_Scenario(Scenario scenario) throws Exception
	{	
		afterMethod(scenario);
	}
	@AfterAll
	public static void Close_Browser() throws Exception
	{				
		tearDown();		
//		driver.quit();
	}

	

	
	
	
	
	
	
}
