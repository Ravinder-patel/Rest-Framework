package RequestChaining_7;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class DeleteFirstProject {
	
	String firstProject;
	
	/* get all the projects via 1st request api req_1 */
	@Test
	public void getAllProjectsTest() {
		
		Response response = given()
		.get("http://106.51.90.215:8084/projects1");
		response
			.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(200)
			.log().all();
		
		ArrayList<String> projectsList = response.jsonPath().get("content.projectId");
		

	firstProject=projectsList.getFirst();
	System.out.println(firstProject);

	}
	
	
	/* delete 1st project via 2nd request */
	@Test(dependsOnMethods = "getAllProjectsTest")
	public void deleteProjectTest() {
					given()
					.delete("http://106.51.90.215:8084/projects/"+firstProject)
						.then()
						.assertThat().statusCode(204)
						.log().all();
						
						}

}
