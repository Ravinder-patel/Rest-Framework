package Authentication_9;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BasicAuthentication {
/*Basic authentication on ninza pay
 * */
	@Test
	public void basicAuthTest() {
		given()
		.contentType(ContentType.JSON)
		.auth().basic("rmgyantra", "rmgy@9999")
		.log().all()
			.when()
			.get("http://49.249.29.5:8091/login")
				.then()
				.contentType(ContentType.JSON)
				.log().all();
		
/*OUTPUT==============
		 * {
    "msg": "Successfully Logged In",
    "username": "rmgyantra",
    "role": "ROLE_ADMIN",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJybWd5YW50cmEiLCJleHAiOjE3MjEzMjI4NzcsImlhdCI6MTcyMTI4Njg3N30.vjqCmGnqtimJm9wK8u7O0G-AodUkXQQaXMF13kFMUfk"
			}
*/
		
		
	}

}
