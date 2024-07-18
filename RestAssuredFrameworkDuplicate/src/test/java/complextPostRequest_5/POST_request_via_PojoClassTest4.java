package complextPostRequest_5;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.Utility.ProjectPOJO;

public class POST_request_via_PojoClassTest4{
	@Test
	public void postRequestViaPojoClassTest() {
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);	
		ProjectPOJO ppObj=new ProjectPOJO("Amazon_"+randomInt, "patel", 50, "completed");//to generate random project names
	
given()
	.contentType(ContentType.JSON)
	.body(ppObj)
	.when()
		.post("http://106.51.90.215:8084/addProject")
		.then()
			.and().log().all()
			.assertThat().statusCode(201);

}
}
