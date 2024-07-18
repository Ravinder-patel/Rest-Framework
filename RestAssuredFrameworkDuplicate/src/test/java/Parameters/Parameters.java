package Parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Parameters {
	/*Path parameter============resource=====
	 * */
	@Test
	public void pathParameterTest() {
		 
		 Response resp = given()
                 .pathParam("projectId", "TY_PROJ_12184")
                 .log().all()
             .when()
                 .get("http://106.51.90.215:8084/projects/{projectId}");
		 				resp.then()
		 				.log().all()
		 				.assertThat().statusCode(200);
	
		
	}
	/*query parameter=========GET method===========
	 * */
	
	@Test
	public void queryParameterTest() {
		 
		 Response resp = given()
                .queryParam("teamSize", 10)
                .log().all()
            .when()
                .get("http://106.51.90.215:8084/projects");
		 				resp.then()
		 				.log().all()
		 				.assertThat().statusCode(200);
	
		
	}
	/*Form parameter============== POST method =============wrong
	 * */
	@Test
	public vid formParameterTest() {
		 //Use post method
		
	}
	/*Form parameter============= POST & GET methods ==============
	 * */
	@Test
	public vod paramParameterTest() {
		 
		
	
		
	}
	
}
