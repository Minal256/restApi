package test_RestApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class SampleDummyPost {

	public static void main(String[] args) {
//	public void httpPostMethod() {

	    //Base URL
	    RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

	    //endpoints related to employees

	    String createUrl = "/create";

	    String deleteUrl = "/delete/{id}";

	    String getAllEmployeesUrl = "/employees";


	    //API Body
	    String apiBody = "{\"name\":\"Pooja\",\"salary\":\"1600000\",\"age\":\"27\"}";

	    given().log().all().header("Content-Type", "application/json; charset=UTF-8").body(apiBody)
	            .when().post(createUrl)
	                    .then().log().all().assertThat().statusCode(200);
	    
	    given().log().all().header("Content-Type", "application/json")
	    .when().get(getAllEmployeesUrl)
	    .then().log().all().extract().response().asString();
		}
	}


