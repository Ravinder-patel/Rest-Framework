package com.sample.crud.without.bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class smapleDeleteProjectTest {
	@Test
	public void deleteProject() {
		
		Response resp = RestAssured.delete("http://106.51.90.215:8084/projects/TY_PROJ_11671");
		resp.then().log().all();
		resp.then().assertThat().statusCode(204);	
	
	}

}
