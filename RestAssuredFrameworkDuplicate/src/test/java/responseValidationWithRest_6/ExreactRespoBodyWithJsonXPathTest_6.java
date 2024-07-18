package responseValidationWithRest_6;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class ExreactRespoBodyWithJsonXPathTest_6 {
	@Test
	public void verifyResponseBodyTest() {

		Response resp = given().get("http://106.51.90.215:8084/projects1");

		resp.then().log().all();

//		ArrayList<String> List1 = JsonPath.read(resp.asString(),".content[*].[?(@.projectName=='Fireflink_DQVOB')].projectId");
//
//		String actualProID = List1.get(0);
//		System.out.println(actualProID);
//
//		Assert.assertEquals(actualProID, "06151");
		
		List<String> projectNames=JsonPath.read(resp.asString(), ".content[*].[?(@.createdBy=='deepak')].projectName"); //based on the condition
		
		for(int i=0;i<=projectNames.size()-1;i++) {
		
		String actualProName = projectNames.get(i);
		Assert.assertEquals(actualProName, "FireCrowd_09393");
		System.out.println(actualProName);
		break;
		
		}

	}

}
