package responseValidationWithRest_6;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class validateResponseTimeTest_2 {
	@Test
	public void verifyResponseTimeTest() {
		
		Response resp = given()
		.get("http://106.51.90.215:8084/projects");
		
		resp.then().log().all();
		
		System.out.println(resp.time());
		
		//resp.then().assertThat().time(TimeUnit.MILLISECONDS);
		resp.then().assertThat().time(Matchers.lessThan(1200l));
		resp.then().assertThat().time(Matchers.greaterThan(500l));
		resp.then().assertThat().time(Matchers.greaterThanOrEqualTo(500l));
		resp.then().assertThat().time(Matchers.lessThanOrEqualTo(1200l));
		//resp.then().assertThat().time(Matchers.both(Matchers.lessThan(1200l).and(Matchers.greaterThan(500l))
		
	}

}
