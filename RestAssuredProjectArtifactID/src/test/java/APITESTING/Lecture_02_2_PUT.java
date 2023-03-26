package APITESTING;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Lecture_02_2_PUT {
	
	@Test
	public static void putmethod()
	{
		//create  data
		JSONObject response = new JSONObject();
		
		response.put("Name", "Mangesh");
		response.put("Role", "Tester");
		
		//create put method
		given().
		    header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(response.toString()).
		when().
		    put("https://reqres.in/api/users/2").
		then().
		    statusCode(200).log().all();

	
		
		
	}

}
