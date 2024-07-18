package complextPostRequest_5;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class POST_request_via_jsonObjectTest1{
	@Test
	public void postRequestViaJsonObjectTest() {

		JSONObject jsonObj = new JSONObject();
		int random = new Random().nextInt(1000);
		jsonObj.put("createdBy", "kamal");
		jsonObj.put("projectName", "Indian"+random+"");
		jsonObj.put("status", "Completed");
		jsonObj.put("status", 50);

		given().contentType(ContentType.JSON).body(jsonObj).when().post("http://106.51.90.215:8084/addProject").then()
				.and().log().all().assertThat().statusCode(201);

	}
}
