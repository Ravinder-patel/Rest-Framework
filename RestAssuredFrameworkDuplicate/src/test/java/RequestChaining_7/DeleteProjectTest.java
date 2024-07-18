package RequestChaining_7;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

import java.util.Random;

import pojoClass.Utility.ProjectPOJO;

public class DeleteProjectTest {
	
	String projectId;
	
	/* pre condition create a project */
	@Test
	public void createProjectTest() {
		
		Random ran=new Random();
		int randomInt = ran.nextInt(1000);
		String projectName="FAANG"+randomInt;
		
		ProjectPOJO pObj=new ProjectPOJO(projectName, "musk", 99, "completed");
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(pObj)
				.when()
				.post("http://106.51.90.215:8084/addProject");
					resp.then()
					.assertThat().contentType(ContentType.JSON).and()
					.statusCode(201)
					.log().all();
					
					projectId = resp.jsonPath().get("projectId");
					
					System.out.println(projectId);
			
		
	}
	/* delete the same project by using request chaining
	 */
	@Test(dependsOnMethods = "createProjectTest")
	public void deleteProjectTest() {
					given()
					.delete("http://106.51.90.215:8084/projects/"+projectId)
						.then()
						.assertThat().statusCode(204)
						.log().all();
						
						}
}
