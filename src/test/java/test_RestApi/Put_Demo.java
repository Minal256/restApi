package test_RestApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Put_Demo {

	@Test
	public void test() {
		// Base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// endpoints related to employees

		String createUrl = "/create";

		String deleteUrl = "/delete/%s";

		String getAllEmployeesUrl = "/employees";
		
		String putUrl ="/update/%s";
		
	String apiBody = "{\"name\":\"Pooja Pingle\",\"salary\":\"1600000\",\"age\":\"27\"}";
		
		String response = given().log().all().header("Content-Type", "application/json").body(apiBody)
	            .when().post(createUrl)
                .then().log().all().assertThat().statusCode(200).body("data.name", equalTo("Pooja Pingle")).extract().body().asString();

		System.out.println(response);
		
		JsonPath jsonPath = new JsonPath(response);
		
		int id = jsonPath.getInt("data.id");
		
		System.out.println(id + "Id fetched using jsonpath");
		
		String idInString = id +"";
		
		String newUrl=String.format(putUrl, idInString);
		
		System.out.println(newUrl+ "Updated Id");

	}
}
