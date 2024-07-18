package Authentication_9;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DigestiveAuth {
	@Test
	public void digestiveAuthTest() {
		given()
		.contentType(ContentType.JSON)
		.auth().digest("rmgyantra", "rmgy@9999")
		.log().all()
			.when()
			.get("http://49.249.29.5:8091/login")
				.then()
				.contentType(ContentType.JSON)
				.log().all();
		
		
	}
}
