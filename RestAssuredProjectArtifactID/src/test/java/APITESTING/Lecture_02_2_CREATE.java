package APITESTING;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Lecture_02_2_CREATE {

	
	// Step 1 : learn how to add and convert data in json by using map
	@Test
	public static void dataUsingMAP()
	{
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("Name","Mangesh");
		map.put("Job","Software QA Engineer");
		
		System.out.println(map);  // it will print the data in normal format
		
		JSONObject response = new JSONObject(map);
		System.out.println(response);
	}
	
	//step 2 : how to use json library to put data
	@Test
	public static void dataUsingJSON()
	{	
		JSONObject response = new JSONObject();
		response.put("Name", "Mangesh");
		response.put("Job", "Tester");
		
		System.out.println(response);
		System.out.println(response.toString());  //recomnded
	}
	
	//Step3 : now are able to create post method
	
	@Test
	public static void  postmethod()
	{
		JSONObject response = new JSONObject();
		response.put("Name", "Mangesh");
		response.put("Role", "Developer");
		
		System.out.println(response.toString());
		
        given().
            header("Content-type" ,"application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
        	body(response.toString()).  ///body should be pass in given section  and any header or parameter requires
        when().
        	post("https://reqres.in/api/users").   // URI must be passed in when section
        then().
        	statusCode(201).log().all();  //what should happn or expected result 
			
	}
	
}
