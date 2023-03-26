package APITESTING;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class Lecture_04 {

	@DataProvider
	public Object[][] testdataforPostMethod()
	{
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Mangesh_dataProvider";
//		data[0][1] = "Sutar_dataProvider";
//		data[0][2] = 1;
//		
//		data[1][0] = "Shreya_dataProvider";
//		data[1][1] = "Panchal_dataProvider";
//		data[1][2] = 2;
//		return data;
//		
//		
		return new Object[][]
				{
			{"Sheetal" , "patil" , 3},
			{"Sheetal1" , "patil1" , 3}
			
				};
		
	}
	@Test(dataProvider = "testdataforPostMethod")
	public void postmethod(String firstname, String lastname, int subjectid)
	{
     	  baseURI = "http://localhost:3000/";
     	  
     	  JSONObject response = new JSONObject();
     	  
     	  response.put("first_name", firstname);
     	  response.put("last_name", lastname);
     	  response.put("subjectId", subjectid);
     	  
     	  
     	  given().
     	  	header("Content-Type", "application/json")
     	  	.contentType(ContentType.JSON).accept(ContentType.JSON)
     	  	.body(response.toString())
     	  .when()
     	  	.post("/users")
     	  .then()
     	  	.statusCode(201).log().all();
     	  
	
	}
	
	
	@DataProvider
	public Object[] testDataforDeletementhod()
	{
		
		return new Object[]{
			8,9
		};
		
	}
	@Test(dataProvider = "testDataforDeletementhod")
	public void deletemethod(int userid)
	{
   	    baseURI = "http://localhost:3000/";
		
   	    when()
   	    	.delete("/users/" +userid)
 	   .then()
   	    	.statusCode(200)
   	    	.log()
   	    	.all();
	}
	
	
}
