package APIs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DELETE_data {
@Test
	
	public void deleteapiresponse ()
	{
	  
	RestAssured.when()
	  .delete("https://reqres.in/api/users/2")
      .then()
      .statusCode(204)
	  .log().all();
}

}
