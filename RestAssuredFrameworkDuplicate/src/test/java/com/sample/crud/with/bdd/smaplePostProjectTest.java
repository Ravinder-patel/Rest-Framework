package com.sample.crud.with.bdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class smaplePostProjectTest {
	@Test
	public void postProject() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "Allu Arjun");
		jsonObj.put("projectName", "Pushpa");
		jsonObj.put("status", "On going");
		jsonObj.put("teamSize", 1);
		
		given()
		.contentType(ContentType.JSON)
			.body(jsonObj.toString())
			.when()	// http methods
				.post("http://106.51.90.215:8084/addProject")
				.then()	// response
					.log().all()
						.assertThat().statusCode(201);
	}

}
