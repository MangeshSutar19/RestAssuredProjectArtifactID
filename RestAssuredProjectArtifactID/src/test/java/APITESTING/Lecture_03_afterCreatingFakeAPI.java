package APITESTING;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Lecture_03_afterCreatingFakeAPI {
	
	@Test
	public void getdata()
	{
		
		baseURI = "http://localhost:3000";
		
		given().
		headers("Content-Type", "application/josn").contentType(ContentType.JSON).accept(ContentType.JSON).
		get("subjects")
		.then()
		.statusCode(200).log().all();
	}
	@Test
	public void getdataByusingparams()
	{
		
		
		baseURI = "http://localhost:3000";
		
		given().
		headers("Content-Type", "application/josn").contentType(ContentType.JSON).accept(ContentType.JSON).
		param("subject_name", "Maths").
		get("subjects?subject_name=Maths")
		.then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void postDataToUSers()
	{
		
		baseURI = "http://localhost:3000";

		//Data
		JSONObject response =  new JSONObject();
		
		response.put("first_name", "Sakshi");
		response.put("last_name", "Mestri");
		response.put("subjectId", 1);
		
		
		given()
			.headers("Content-Type", "application/josn").contentType(ContentType.JSON).accept(ContentType.JSON).
			body(response.toString()).
        when().
			post("/users").
		then().
			statusCode(201).log().all();
         

		
	}

	@Test
	public void updatebyusingPATCHDatafromUSers()
	{
		
		baseURI = "http://localhost:3000";

		//Data
		JSONObject response =  new JSONObject();
		
		response.put("first_name", "Anushree");
		response.put("last_name", "Khubade");
		response.put("subjectId", 1);
		
		
		given()
			.headers("Content-Type", "application/josn").contentType(ContentType.JSON).accept(ContentType.JSON).
			body(response.toString()).
        when().
			patch("/users/4").
		then().
			statusCode(200).log().all();
         

		
	}
	@Test
	public void updatebyusingPUTDatafromUSers()
	{
		
		baseURI = "http://localhost:3000";

		//Data
		JSONObject response =  new JSONObject();
		
		response.put("first_name", "Anushree");
		response.put("last_name", "Khubade");
		response.put("subjectId", 1);
		
		
		given()
			.headers("Content-Type", "application/josn").contentType(ContentType.JSON).accept(ContentType.JSON).
			body(response.toString()).
        when().
			put("/users/5").
		then().
			statusCode(200).log().all();
         

		
	}


	@Test
	public void DeleteDatafromUSers()
	{
		
		baseURI = "http://localhost:3000";
        when().
			delete("/users/5").
		then().
			statusCode(200).log().all();
         

		
	}


	

}
