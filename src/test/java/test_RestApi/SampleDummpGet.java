package test_RestApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleDummpGet {

		@Test
		public void test() {

		// Base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// endpoints related to employees

		String createUrl = "/create";

		String deleteUrl = "/delete/{id}";

		String getAllEmployeesUrl = "/employees";
		
		String response = given().log().all().header("Content-Type", "application/json")
				.when().get(getAllEmployeesUrl).then().log().all().extract().response().asString();
		System.out.println(response +"Response Data");
				
	}

}
