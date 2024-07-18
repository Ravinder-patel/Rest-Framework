package responseValidationWithRest_6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class validateResponseHeaderTest_1 {
	@Test
	public void verifyHeaderTest() {
		
//		Response resp = given()
//		.get("http://106.51.90.215:8084/projects");
		
		
		//to print the request body
		given()
	    .log().all()  // Logs the entire request
	    .when()
	    .get("http://106.51.90.215:8084/projects")
	    .then()
	    .statusCode(200);
		
//		resp.then().log().all();
//		resp.then().assertThat().statusLine("HTTP/1.1 200 ");
//		resp.then().assertThat().header("Transfer-Encoding", "chunked");
		
	}

}
