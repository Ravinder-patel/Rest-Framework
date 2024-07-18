package EndPoints_16;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.generic.database.utility.DatabaseUtility;
import com.ninza.hrm.generic.file.utility.PropertiesFileUtility;
import com.ninza.hrm.genric.java.utility.JavaUtility;

import Base.Api.BaseClass;
import EndPoints.Utility.IEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Utility.ProjectPOJO;

public class Project {
	
	ProjectPOJO proObj;
	@Test
	public void addSingleProjectWithCreated() throws Throwable {
		DatabaseUtility DBLib = new DatabaseUtility();
		JavaUtility jLib = new JavaUtility();
		PropertiesFileUtility pfLib = new PropertiesFileUtility();
		
		int randomInteger = jLib.getRandomInteger();
		String projectName = "Telsa_"+randomInteger;
		String expMsg="Successfully Added";
		
		proObj=new ProjectPOJO(projectName, "elon", 10, "Created");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(proObj)
			.when()
			.post(pfLib.getDataFromProperties("BASEUri")+ IEndpoints.ADDProject);
		resp.then()
		.log().all();
		/*Verify in API response body*/
		resp.then()
		.assertThat().time(Matchers.lessThan(3000l))
		.assertThat().statusCode(201);
		
		String actualProjectName = resp.jsonPath().get("projectName");
		String actMsg=resp.jsonPath().get("msg");
		Assert.assertEquals(expMsg, actMsg);
		Assert.assertEquals(projectName, actualProjectName); //TestNg Validation
		
		
		/*Verify in DATABASE*/
		boolean flag= false;
	ResultSet result = DBLib.executeSelectQuery("select * from project");
		while (result.next()) {
			if (result.getString(4).equals(projectName)) {
				flag = true;
				break;
			}
		}
		DBLib.closeConnection();
		Assert.assertTrue(flag,"project in DB is not verified");
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
