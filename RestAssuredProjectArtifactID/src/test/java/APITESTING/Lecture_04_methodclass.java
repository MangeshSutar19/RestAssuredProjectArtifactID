package APITESTING;

import org.testng.annotations.Test;
import java.util.jar.JarOutputStream;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.annotations.*;

import io.restassured.http.ContentType;

public class Lecture_04_methodclass {

	@Test(dataProvider = "testdataforpostmethod", dataProviderClass = Lecture_04_dataproviderclass.class)
	public void postmethod(String firstname, String lastname, int userid)
	
	{
		JSONObject resposne = new JSONObject();
		resposne.put("first_name", firstname);
		resposne.put("last_name", lastname);
		resposne.put("subjectId", userid);
		
		baseURI = "http://localhost:3000/";
		 
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(resposne.toString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log()
			.all();

		
	}
	
	@Parameters({"userid"})
	@Test
	public void deleteMethod(int userid)
	{
		System.out.println("Value of user id is " +userid);
		
		baseURI = "http://localhost:3000/";

		when().delete("/users/" +userid).
		then().statusCode(200).log().all();
		
	}
}
