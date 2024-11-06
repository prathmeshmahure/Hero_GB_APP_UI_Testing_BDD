package GB_APP.ExcelDataProvider;

import GB_APP.Utility.Library;

public class excelTestData {
	public static String MobileNumber = Library.getExcelData(0, 1, 0);
	public static String EmergencyMobileNumber = Library.getExcelData(0, 1, 1);
	public static String Otp = Library.getExcelData(0, 1, 2);
	public static String Username = Library.getExcelData(0, 1, 4);
	public static String Password = Library.getExcelData(0, 1, 5);
}
