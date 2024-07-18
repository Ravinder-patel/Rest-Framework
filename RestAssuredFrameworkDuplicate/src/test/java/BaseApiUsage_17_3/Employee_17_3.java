package BaseApiUsage_17_3;

import static io.restassured.RestAssured.given;

import java.sql.ResultSet;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Api.BaseClass;
import EndPoints.Utility.IEndpoints;
import pojoClass.Utility.EmployeePOJO;
import pojoClass.Utility.ProjectPOJO;

public class Employee_17_3 extends BaseClass {

	/*Add an employee======
	 * 1. create Project 
	 * 2. add employee to the same project*/
	
	@Test
	public void addEmploye() throws Throwable {
		// create an object to POJO class
		
		int ranndomInt = jLib.getRandomInteger();
		String projectName = "NINZA_" + ranndomInt;
		String userName = "Patel_" + ranndomInt;
		
		// API Req-1 ==> add a project in inside server
		ProjectPOJO proObj = new ProjectPOJO(projectName, "created", 0, "completed");
		given()
		.spec(reqspec)
		.body(proObj)
			.when()
			.post(IEndpoints.ADDProject)
				.then()
				.log().all();
		
		// API Req-2 ==> add employee to same project
		EmployeePOJO empObj = new EmployeePOJO("TestEngg", "27/04/1999", "ram@gmail.com", userName, 3,
				"1236547890", projectName, "ROLE_EMPLOYEE", userName);
		given()
		.spec(reqspec)
		.body(empObj)
			.log().all()
			.when()
			.post(IEndpoints.ADDEmployyee)
				.then()
				.assertThat().statusCode(201)
				.and().time(Matchers.lessThan(3000L))
				.spec(resspec)
				.log().all();
		
		
		// Verify Emp Name in DataBase
		boolean flag = false;
		ResultSet result=DBLib.executeSelectQuery("select * from employee");
		while (result.next()) {
			if (result.getString(5).equals(userName));
			{
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag, "Employee in DB is not verified");
		System.out.println("Verified in db=============");
	}
	
	/*Add an employee withoutemail======
	 * 1. create employee obj try to add  the employee 
	 * 2.  add employee to same project without email*/
	@Test
	public void addEmployeWithOutEmail() throws Throwable {
		// create an object to POJO class
		int ran = jLib.getRandomInteger();
		String projectName = "ZOHO_" + ran;
		String userName = "karan_" + ran;
		
		// API Req -1 ==> add a project in server
		ProjectPOJO  proObj = new ProjectPOJO(projectName, "Patel", 10, "created");
		given()
		.spec(reqspec)
		.body(proObj)
		.log().all()
			.when()
			.post(IEndpoints.ADDProject)
				.then()
				.spec(resspec)
				.log().all();
		
		// API Req-2 ==> add employee to same project without email
		EmployeePOJO empObj = new EmployeePOJO("TestEngg", "27/04/1999", "", userName, 3,
				"9876543210", projectName, "ROLE_EMPLOYEE", userName);
		given()
		.spec(reqspec)
		.body(empObj)
			.when()
			.post(IEndpoints.ADDEmployyee)
				.then()
					.assertThat().statusCode(500)
					.spec(resspec)
					.log().all();

	
	
}
}
