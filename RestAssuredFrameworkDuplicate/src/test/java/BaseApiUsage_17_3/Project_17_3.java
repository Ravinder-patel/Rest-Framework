package BaseApiUsage_17_3;

import static io.restassured.RestAssured.given;

import java.sql.ResultSet;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Api.BaseClass;
import EndPoints.Utility.IEndpoints;
import io.restassured.response.Response;
import pojoClass.Utility.ProjectPOJO;

public class Project_17_3 extends BaseClass {
	
	ProjectPOJO proObj;
	@Test
	public void addSingleProjectWithCreated() throws Throwable {
		
		int randomInteger = jLib.getRandomInteger();
		String projectName = "Telsa_"+randomInteger;
		String expMsg="Successfully Added";
		
		proObj=new ProjectPOJO(projectName, "elon", 10, "Created");
		
		Response resp = given()
				.spec(reqspec)
		.body(proObj)
			.when()
			.post(IEndpoints.ADDProject);
		resp.then()
		.spec(resspec)
		.log().all();
		
		/*Verify in API response body=========================*/
		resp.then()
		.assertThat().time(Matchers.lessThan(3000l))
		.assertThat().statusCode(201);
		
		String actualProjectName = resp.jsonPath().get("projectName");
		String actMsg=resp.jsonPath().get("msg");
		Assert.assertEquals(expMsg, actMsg);
		Assert.assertEquals(projectName, actualProjectName); //TestNg Validation
		
		
		/*Verify in DATABASE=======================*/
		boolean flag= false;
		ResultSet result = DBLib.executeSelectQuery("select * from project");
		while (result.next()) {
			if (result.getString(4).equals(projectName)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag,"project in DB is not verified");
}

	
	@Test(dependsOnMethods ="addSingleProjectWithCreated")
	public void addDuplicateProject() {
		given()
		.spec(reqspec)
		.body(proObj)
		.when()
		.post(IEndpoints.ADDProject)
			.then()
			.spec(resspec)
			.assertThat().statusCode(409)
			.log().all();
	}
	
}
