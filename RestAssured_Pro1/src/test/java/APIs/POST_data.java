package APIs;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_data {


	@Test
	
	public void postapiresponse ()
	{
		
		RestAssured.baseURI = "https://reqres.in/api" ;
		
		// Request Object
		RequestSpecification ga = RestAssured.given();
		
		JSONObject request = new JSONObject();
		request.put("name", "komal");
		request.put("job", "testing");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		ga.header("Content-Type","application/json");
		ga.body(request.toJSONString());
		
		//Response Object
		Response response = ga.request(Method.POST ,"/users");
		
		// Print response
		String responsepoutput = response.getBody().asString();
		System.out.println("Ouput Response is : " +responsepoutput);
		
		// Status code validation
		
		int status_code = response.getStatusCode();
		System.out.println("Status Code is : "+status_code );
		Assert.assertEquals(status_code, 201);
		
		// Status line verification
		
		String status_line = response.getStatusLine ();
		System.out.println("Status Line is : " +status_line);
		Assert.assertEquals(status_line, "HTTP/1.1 201 Created");
		
		
		
		/*
		JSONObject request = new JSONObject();
		request.put("name", "komal");
		request.put("job", "testing");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		RestAssured.given()
						  .header("Content-Type","application/json")
						  .contentType(ContentType.JSON)
						  .accept(ContentType.JSON)
						  .body(request.toJSONString())
				 .when()
				    	  .post("https://reqres.in/api/users")
				     .then()
				           .statusCode(201).log().all();
		*/
		
   }

}
