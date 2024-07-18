package com.sample.crud.with.bdd;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class smapleDeleteProjectTest {
	@Test
	public void deleteProject() {
		
		given()
			.delete("http://106.51.90.215:8084/projects/TY_PROJ_11670")
			.then()
				.log().all()
					.assertThat().statusCode(204);
	
	}

}
