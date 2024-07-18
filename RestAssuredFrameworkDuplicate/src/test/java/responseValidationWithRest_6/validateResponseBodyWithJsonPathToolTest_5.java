package responseValidationWithRest_6;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class validateResponseBodyWithJsonPathToolTest_5 {
	@Test
	public void verifyResponseBodyTest() {

		Response resp = given().get("http://106.51.90.215:8084/projects1");

		//resp.then().log().all();

		ArrayList<String> List1 = resp.jsonPath(). get("content.projectId");

		System.out.println(List1);

	}

}
