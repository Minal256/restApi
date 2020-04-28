package test_RestApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssertionOnBody {
	
	@Test
	public void test() {
		// Base URL
				RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

				// endpoints related to employees

				String createUrl = "/create";

				String deleteUrl = "/delete/{id}";

				String getAllEmployeesUrl = "/employees";
				
				String apiBody = "{\"name\":\"Pooja Pingle\",\"salary\":\"1600000\",\"age\":\"27\"}";
				
				given().log().all().header("Content-Type", "application/json; charset=UTF-8").body(apiBody)
	            .when().post(createUrl)
	                    .then().log().all().assertThat().statusCode(200).body("data.name", equalTo("Pooja Pingle"));
				
				given().log().all().header("Content-Type", "application/json; charset=UTF-8").body(apiBody)
	            .when().post(createUrl)
	                    .then().log().all().assertThat().statusCode(200).body("data.salary", equalTo("16000"));
	}

}
