package BackendApiTestAutomation_14;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.ninza.hrm.genric.java.utility.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Utility.ProjectPOJO;

public class Project {
	
	ProjectPOJO proObj;
	@Test
	public void addSingleProjectWithCreated() throws Throwable {
		
		JavaUtility jUtil=new JavaUtility();
		int randomInteger = jUtil.getRandomInteger();
		String projectName = "Telsa_"+randomInteger;
		String expMsg="Successfully Added";
		
		proObj=new ProjectPOJO(projectName, "elon", 10, "Created");
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(proObj)
		
		.when()
		.post("http://106.51.90.215:8084/addProject");

		resp.then()
		.log().all();
		/*Verify in API response body*/
		resp.then()
		.assertThat().time(Matchers.lessThan(3000l))
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		String actualProjectName = resp.jsonPath().get("projectName");
		String actMsg=resp.jsonPath().get("msg");
		Assert.assertEquals(expMsg, actMsg);
		Assert.assertEquals(projectName, actualProjectName); //TestNg Validation
		
//		
//		/*Verify in DATABASE*/
//		boolean flag= false;
//		Driver driverRef= new Driver();
//		DriverManager.registerDriver(driverRef);
//		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
//		ResultSet result= con.createStatement().executeQuery("select * from project");
//		while (result.next()) {
//			if (result.getString(4).equals(projectName)) {
//				flag = true;
//				break;
//			}
//		}
//		con.close();
//		Assert.assertTrue(flag,"project in DB is not verified");
		}
	

	@Test(dependsOnMethods ="addSingleProjectWithCreated")
	public void addDuplicateProject() {
		given()
		.contentType(ContentType.JSON)
		.body(proObj)
		.post("http://106.51.90.215:8084/addProject")
		.then()
		.assertThat().statusCode(409)
		.log().all();
		
	}
		


}
