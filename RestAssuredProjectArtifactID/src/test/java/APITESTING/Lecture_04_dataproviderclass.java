package APITESTING;
import org.testng.annotations.*;

public class Lecture_04_dataproviderclass {
	
	@DataProvider(name="testdataforpostmethod")
	public Object[][] testdataforPostmethod1()
	{
		
		Object[][] data1 = new Object[2][3];
		data1[0][0] = "Chinky";
		data1[0][1] = "Panchal";
		data1[0][2] = 2;
		
		data1[1][0] = "Minky";
		data1[1][1] = "Dande";
		data1[1][2] = 2;
		
		return data1;
		
	}
	
	public Object[][] testdataforPostMethod2()
	{
		return new Object[][] {
			
			{"Salman","Khan",3},
			{"Akshay"  , "Kumar", 2}
			
		};
	}
 
}
