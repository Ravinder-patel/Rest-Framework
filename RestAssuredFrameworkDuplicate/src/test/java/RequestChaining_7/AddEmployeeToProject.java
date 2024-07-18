package RequestChaining_7;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Utility.ProjectPOJO;

public class AddEmployeeToProject {
	
String actProjectName;
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
					
					actProjectName = resp.jsonPath().get("projectName");
					
					System.out.println(actProjectName);
					
			
		
	}
	
	/* delete the same project by using request chaining===========Error in addEmployeeToProjectTest
	 */
	@Test(dependsOnMethods = "createProjectTest")
	public void addEmployeeToProjectTest() {
		String empObj="{\r\n"
				+ "  \"designation\": \"Employee\",\r\n"
				+ "  \"dob\": \"06/06/1999\",\r\n"
				+ "  \"email\": \"ram@gmail.com\",\r\n"
				+ "  \"empName\": \"sundarsichai\",\r\n"
				+ "  \"experience\": 10,\r\n"
				+ "  \"mobileNo\": \"7531898460\",\r\n"
				+ "  \"project\": \""+actProjectName+"\",\r\n"
				+ "  \"role\": \"ROLE_EMPLOYEE\",\r\n"
				+ "  \"username\": \""+"sundarpichai"+new Random().nextInt(200)+"\"\r\n"
				+ "}";
		
					Response resp = given()
					.contentType(ContentType.JSON)
					.body(empObj)
					.when()
					.post("http://49.249.28.218:8091/employees");
					resp.then()
						.assertThat().statusCode(201)
						.log().all();
						
						}

}
