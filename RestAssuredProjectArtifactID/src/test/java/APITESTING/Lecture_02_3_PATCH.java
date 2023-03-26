
package APITESTING;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
 

public class Lecture_02_3_PATCH {

	@Test
  public static void patchmethod()
  {
	  JSONObject res = new JSONObject();
	  res.put("Name", "Mangesh");
	  res.put("role", "Tester");
	  System.out.println(res.toString());
	 

	  given()
	   .headers("Content-Type" , "application/json")
	   .contentType(ContentType.JSON).accept(ContentType.JSON)
	   .body(res.toString()).
	  when()
	    .patch("https://reqres.in/api/users/2").
	  then()
	    .statusCode(200).log().all();
  
  
  }
	
}
