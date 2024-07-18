package RequestChaining_7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteEmployee {
	/* get an employee via 1st API request */
	@Test
	public void getEmployeeTest() {
		
		//
		
		given()
		.get("http://106.51.90.215:8084/employees")
		.then()
		.log().all();
		
		
		

	}

	/* delete the same employee from above request */
	@Test(dependsOnMethods = "getEmployeeTest")
	public void deleteEmployee() {
		
		

	}
}
