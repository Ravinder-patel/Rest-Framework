package com.sample.crud.without.bdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class smaplePostProjectTest {
	@Test
	public void postProject() {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "patel");
		jsonObj.put("projectName", "kalki");
		jsonObj.put("status", "completed");
		jsonObj.put("teamSize", 6);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonObj.toString()); // pass the json object
		
		Response resp = reqSpec.post("http://106.51.90.215:8084/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);
	}

}
