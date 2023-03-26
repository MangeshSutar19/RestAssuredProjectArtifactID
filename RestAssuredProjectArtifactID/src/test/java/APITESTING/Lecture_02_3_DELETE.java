package APITESTING;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class Lecture_02_3_DELETE {
@Test
	public static void  delete()
	{
       when().    //we can use either when or given function here
       		delete("https://reqres.in/api/users/7").
       then().
       		statusCode(204).log().all();
       		
		
	}
}
