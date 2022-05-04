package APIs;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PUT_data {
	
@Test
	
	public void putapiresponse ()
	{
//		HashMap data = new HashMap();
//		data.put("name", "Tom");
//		data.put("job", "testing");
//		
//		System.out.println(data);
		
		JSONObject request = new JSONObject();
		request.put("name", "Jerry");
		request.put("job", "testing");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		
		RestAssured.given()
						  .header("Content-Type","application/json")
						  .contentType(ContentType.JSON)
						  .accept(ContentType.JSON)
						  .body(request.toJSONString())
						  
				    .when()
				    	  .put("https://reqres.in/api/users/2")
				     .then()
				           .statusCode(200)
						   .log().all();
		
		
	}


}
