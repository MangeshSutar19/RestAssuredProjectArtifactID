package APITESTING;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


public class Lecture_02_1_GET {
	
	@Test
	public void test1_Alllogs()
	{
	 
	    given()
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();  // it will show all the information which is used for able given request

		//		.body("data.id[1]", equalTo(8));
	}
	@Test
	public void test1_particularparameter()
	{
	 
	    given()
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8));
	}
	@Test
	public void test1_ToaddHeader()
	{
	 
	    given()
	    .header("content-type", "application/json")  // we should provide header here  and parameter here
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8));
	}
}
