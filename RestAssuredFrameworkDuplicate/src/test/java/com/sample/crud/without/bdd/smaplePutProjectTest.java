package com.sample.crud.without.bdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class smaplePutProjectTest {
	@Test
	public void putProject() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "ravi");
		jsonObj.put("projectName", "kalki 2898 AD");
		jsonObj.put("status", "completed");
		jsonObj.put("teamSize", 50);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonObj.toString()); // pass the json object
		
		Response resp = reqSpec.put("http://106.51.90.215:8084/projects/TY_PROJ_11693");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}

}
