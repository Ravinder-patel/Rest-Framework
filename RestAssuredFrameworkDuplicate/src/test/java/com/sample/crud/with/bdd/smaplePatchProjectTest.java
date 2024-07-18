package com.sample.crud.with.bdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class smaplePatchProjectTest {
	@Test
	public void putProject() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy","PatelG");
		
	given()
		.contentType(ContentType.JSON)
			.body(jsonObj.toJSONString())
			// PATCH is not working now
			.when()
				.patch("http://106.51.90.215:8084/projects/TY_PROJ_11722")
				.then()
					.log().all()
						.assertThat().statusCode(200);
		
	
	}

}
