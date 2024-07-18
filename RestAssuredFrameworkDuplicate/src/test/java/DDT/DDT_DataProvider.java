package DDT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DDT_DataProvider {

	@Test(dataProvider = "getData")
	public void createProject(String creatorName, String ProName) {
		String projectBody="{\r\n"
				+ "  \"createdBy\": \""+creatorName+"\",\r\n"
				+ "  \"projectName\": \""+ProName+"\",\r\n"
				+ "  \"status\": \"Created\",\r\n"
				+ "  \"teamSize\": 10\r\n"
				+ "}";
		
		given()
		.contentType(ContentType.JSON)
		.body(projectBody)
		
		.when()
		.post("http://106.51.90.215:8084/addProject")
		
		.then()
		.log().all();	
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] arrObj=new Object[3][2];
		arrObj[0][0]="Ravi";
		arrObj[0][1]="Meta_1";
		arrObj[1][0]="Ravi";
		arrObj[1][1]="Meta_2";
		arrObj[2][0]="Ravi";
		arrObj[2][1]="Meta_3";
		return arrObj;
	}

}
