package com.ninza.hrm.api.projectTest;

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
import io.restassured.response.Response;
import pojoClass.Utility.ProjectPOJO;

public class ProjectTest {

		String projectName;
		ProjectPOJO pobj;
	@Test
	public void addSingleProjectWithCreateTest() throws Throwable {
			
			Random random= new Random();
			int randomInt=random.nextInt(5000);
			String expMsg="Successfully Added";
			projectName = "NINZA_"+randomInt;
		    pobj= new ProjectPOJO (projectName, "created", 8, "Comppleted");
			
		Response resp= given()
					.contentType(ContentType.JSON)
					.body(pobj)
					.post("http://106.51.90.215:8084/addProject");
			
			//Verify the response body
			resp.then()
				.assertThat().statusCode(201)
				.assertThat().time(Matchers.lessThan(3000L))
				.assertThat().contentType(ContentType.JSON)
				.log().all();
			
		//Verify the projectName in API layer
		String actMsg=resp.jsonPath().get("msg");
		Assert.assertEquals(expMsg, actMsg);
		
		
		//Verify the projectName in DataBase layer
		boolean flag= false;
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
		ResultSet result= con.createStatement().executeQuery("select * from project");
		while (result.next()) {
			if (result.getString(4).equals(projectName)) {
				flag = true;
				break;
			}
		}
		con.close();
		Assert.assertTrue(flag,"project in DB is not verified");
		}
		
		
		

		@Test(dependsOnMethods ="addSingleProjectWithCreateTest")
		public void addDuplicateProject() {
			given()
			.contentType(ContentType.JSON)
			.body(pobj)
			.post("http://106.51.90.215:8084/addProject")
			.then()
			.assertThat().statusCode(409)
			.log().all();
			
		}
	

}
