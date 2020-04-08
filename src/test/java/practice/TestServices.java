package practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestServices {

	@Test
	public void test() {
		
		System.out.println("Hello Rest API");
		
		// Rest API's URL
		String restAPIUrl = "http://dummy.restapiexample.com/api/v1/create";
		
		// API Body
		String apiBody = "{\"name\":\"Minal\",\"salary\":\"600000\",\"age\":\"28\"}";
		System.out.println(apiBody );
		
		// Building request by using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		//Set API's Body
		builder.setBody(apiBody);
		
		//Setting content type as application/json
		builder.setContentType("application/json; charset=UTF-8");
		
		Response response = given().when().post(restAPIUrl);
		System.out.println(response.asString());
		

	}
}
