package com.sample.crud.with.bdd;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class smapleGetProjectTest {
	@Test
	public void getProject() {
	when()
		.get("http://106.51.90.215:8084/projects")
		.then()
			.log().all()
				.assertThat().statusCode(200);
				
	}

}
