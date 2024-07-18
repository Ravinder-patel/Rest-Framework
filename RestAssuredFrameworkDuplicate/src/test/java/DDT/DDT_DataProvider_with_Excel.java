package DDT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninza.hrm.generic.file.utility.ExcelFileUtility;

import io.restassured.http.ContentType;

public class DDT_DataProvider_with_Excel {

	@Test(dataProvider = "getData")
	public void createProject(String ProName , String creatorName) {
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
	public Object[][] getData() throws Throwable {
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		int count=eUtil.getRowCount("Projects");
		
		
		Object[][] arrObj=new Object[count][2];
		for (int i = 0; i <count ; i++) {
			arrObj[i][0]=eUtil.getDataFromExcel("Projects", i+1, 0);
			arrObj[i][1]=eUtil.getDataFromExcel("Projects", i+1, 1);;
					}
		
		return arrObj;
	}

}
