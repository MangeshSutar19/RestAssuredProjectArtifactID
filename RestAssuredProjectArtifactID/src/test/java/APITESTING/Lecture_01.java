package APITESTING;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Lecture_01 {
	
	@Test
	public void test_01_get()
	{

	 Response response = get("https://reqres.in/api/users?page=2");
	 System.out.println("Status code " +response.getStatusCode());
	 System.out.println("API BDOY " +response.getBody());
	 System.out.println("response in strinng as a body " +response.asString());
	 System.out.println("Get status line " +response.getStatusLine());
	 System.out.println("Get time " +response.getTime());
	 System.out.println("Get header given header " +response.getHeader("content-type"));
	 
	 int statuscode = response.getStatusCode();
	 Assert.assertEquals(statuscode, 280);
	}
	@Test
	public void test_02_get()
	{
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]",equalTo(7));
		
		
	}
	
}
