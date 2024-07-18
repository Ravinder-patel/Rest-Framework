package com.sample.crud.with.bdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class smaplePutProjectTest {
	@Test
	public void putProject() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Allu Arjun");
		jsonObj.put("projectName", "Pushpa2");
		jsonObj.put("status", "On going");
		jsonObj.put("teamSize", 100);
		
	given()
		.contentType(ContentType.JSON)
			.body(jsonObj.toString())
				.put("http://106.51.90.215:8084/projects/TY_PROJ_11722")
					.then().log().all()
						.assertThat().statusCode(200);
	}

}
