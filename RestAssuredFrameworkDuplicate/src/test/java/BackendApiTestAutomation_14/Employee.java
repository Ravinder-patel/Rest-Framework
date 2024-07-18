package BackendApiTestAutomation_14;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import pojoClass.Utility.EmployeePOJO;
import pojoClass.Utility.ProjectPOJO;

public class Employee {
	
	/*Add an employee======
	 * 1. create Project 
	 * 2. add employee to the same project*/
	
	@Test
	public void addEmploye() throws Throwable {
		// create an object to POJO class
		Random random = new Random();
		int ranndomInt = random.nextInt(5000);
		String projectName = "NINZA_" + ranndomInt;
		String userName = "Patel_" + ranndomInt;
		
		// API Req-1 ==> add a project in inside server
		ProjectPOJO pro = new ProjectPOJO(projectName, "created", 0, "completed");
		given()
		.contentType(ContentType.JSON)
		.body(pro)
			.when()
			.post("http://49.249.28.218:8091/addProject")
				.then()
				.log().all();
		
		// API Req-2 ==> add employee to same project
		EmployeePOJO emp = new EmployeePOJO("TestEngg", "27/04/1999", "ram@gmail.com", userName, 3,
				"1236547890", projectName, "ROLE_EMPLOYEE", userName);
		given()
		.contentType(ContentType.JSON)
		.body(emp)
			.log().all()
			.when()
			.post("http://49.249.28.218:8091/employees")
				.then()
				.assertThat().statusCode(201)
				.and().contentType(ContentType.JSON)
				.and().time(Matchers.lessThan(3000L)).log().all();
		
		
		// Verify Emp Name in DataBase
		boolean flag = false;
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
		ResultSet result = con.createStatement().executeQuery("select * from employee");
		while (result.next()) {
			if (result.getString(5).equals(userName));
			{
				flag = true;
				break;
			}
		}
		con.close();
		Assert.assertTrue(flag, "Employee in DB is not verified");
		System.out.println("Verified in db=============");
	}
	
	/*Add an employee withoutemail======
	 * 1. create employee obj try to add  the employee 
	 * 2.  add employee to same project without email*/
	@Test
	public void addEmployeWithOutEmail() throws Throwable {
		// create an object to POJO class
		Random random = new Random();
		int ran = random.nextInt(5000);
		String projectName = "ZOHO_" + ran;
		String userName = "karan_" + ran;
		
		// API Req -1 ==> add a project in server
		ProjectPOJO  pro = new ProjectPOJO(projectName, "Patel", 10, "created");
		given()
		.contentType(ContentType.JSON)
		.body(pro)
		.log().all()
			.when()
			.post("http://49.249.28.218:8091/addProject")
				.then()
				.log().all();
		
		// API Req-2 ==> add employee to same project without email
		EmployeePOJO emp = new EmployeePOJO("TestEngg", "27/04/1999", null, userName, 3,
				"9876543210", projectName, "ROLE_EMPLOYEE", userName);
		given()
		.contentType(ContentType.JSON)
		.body(emp)
			.when()
			.post("http://49.249.28.218:8091/employees")
				.then()
					.assertThat().statusCode(500)
					.log().all();

	
	
}
}
