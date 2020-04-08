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
	    String apiBody = "{\"name\":\"Minal Bhasme\",\"salary\":\"600000\",\"age\":\"26\"}";

	    given().log().all().header("Content-Type", "application/json").body(apiBody)
	            .when().post(createUrl)
	                    .then().log().all().assertThat().statusCode(200);
		}
	}


