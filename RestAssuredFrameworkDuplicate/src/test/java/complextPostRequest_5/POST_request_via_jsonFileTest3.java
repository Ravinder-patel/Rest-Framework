package complextPostRequest_5;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class POST_request_via_jsonFileTest3 {
	@Test
	public void postRequestViaJsonFileTest() {

		File jfile=new File("./SampleProject.json");

		given()
		.contentType(ContentType.JSON).body(jfile)
			.when()
			.post("http://106.51.90.215:8084/addProject")
				.then()
				.and().log().all()
				.assertThat().statusCode(201);

	}
}
