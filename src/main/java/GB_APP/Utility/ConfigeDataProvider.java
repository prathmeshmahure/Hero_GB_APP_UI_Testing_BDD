package GB_APP.Utility;



public class ConfigeDataProvider extends PageClassObject {

	public static String UserDirectoryPath = System.getProperty("user.dir");
	public static String browser = Library.getStringConfigData("browser");
	public static String AppPath = Library.getStringConfigData("AppPath");
	public static String IpAdress = Library.getStringConfigData("IpAdress");
	public static String Url = Library.getStringConfigData("Url");
	public static int Port = Library.getNumericConfigData("Port");
	public static String Username = Library.getStringConfigData("Username");
	public static String Otp = Library.getStringConfigData("Otp");
	
	public static String EmulatorDeviceName = Library.getStringConfigData("EmulatorDeviceName");
	public static String RealDeviceName = Library.getStringConfigData("RealDeviceName");
	public static String pCloudy_DeviceManufacturer = Library.getStringConfigData("pCloudy_DeviceManufacturer");
	public static String pCloudy_DeviceVersion = Library.getStringConfigData("pCloudy_DeviceVersion");	
	public static String Platform_name = Library.getStringConfigData("Platform_name");
	
//	public static String Platform_Android = PlatForm.ANDROID.toString();
	
	public static String emailid = Library.getStringConfigData("EmailS");
	public static String pass = Library.getStringConfigData("PassS");
	

	public static String MobileNumber = Library.getStringConfigData("MobileNumber1");
	public static String EmergencyMobileNumber = Library.getStringConfigData("MobileNumber2");
	
	public static String ParulEmail = Library.getStringConfigData("ParulEmail");
	
	
	////////////////////////Web Admin Data   ////////////////////////
	public static String CustomerWebUrl = Library.getStringConfigData("CustomerWebUrl");
	public static String hero_hub_url = Library.getStringConfigData("UatUrl");
	////////////////////////   Web Admin Data   ////////////////////////
	
	public static String TarunEmail = Library.getStringConfigData("TarunEmail");
	public static String TarunPassword = Library.getStringConfigData("TarunPassword");
	public static String ShashikantEmailId = Library.getStringConfigData("ShashikantEmailId");
	public static String ShashikantPassword = Library.getStringConfigData("ShashikantPassword");
	
	
	
	
	
	
	
	
}
