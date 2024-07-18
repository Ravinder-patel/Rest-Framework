package com.sample.crud.without.bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class smapleGetProjectTest {
	@Test
	public void getProject() {
		Response resp = RestAssured.get("http://106.51.90.215:8084/projects");
		resp.prettyPrint();
		resp.then().assertThat().statusCode(200);
		resp.then().log().all();
	}

}
