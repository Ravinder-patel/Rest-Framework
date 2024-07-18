package complextPostRequest_5;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class POST_request_via_HashMapTest2{
	@Test
	public void postRequestViaJsonObjectTest() {
		
	HashMap<String,Object> mapObj=new HashMap();
	mapObj.put("createdBy", "Rahasya");
	mapObj.put("projectName", "Amazon Pay");
	mapObj.put("status", "On going");
	mapObj.put("status", 10);
	
given()
	.contentType(ContentType.JSON)
	.body(mapObj)
	.when()
		.post("http://106.51.90.215:8084/addProject")
		.then()
			.and().log().all()
			.assertThat().statusCode(201);

}
}
