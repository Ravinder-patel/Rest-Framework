package responseValidationWithRest_6;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class validateResponseBodyTest_3 {
	@Test
	public void verifyResponseBodyTest() {

		Response resp = given().get("http://106.51.90.215:8084/projects1");

		//resp.then().log().all();

		List<String> list = JsonPath.read(resp.asString(), "content[*].projectName");
		for (String data : list) {
			System.out.println(data);

		}

		System.out.println(list);

	}

}
