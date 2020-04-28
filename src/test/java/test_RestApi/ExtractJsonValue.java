package test_RestApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ExtractJsonValue {
	
	@Test
	public void test() {
		// Base URL
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// endpoints related to employees

		String createUrl = "/create";

		String deleteUrl = "/delete/%s";

		String getAllEmployeesUrl = "/employees";
		
		String putUrl ="/update/%s";
		
//		String name = "Minal %s %s  Bhasme"; //Minal husbandname1 %s Bhasme -> Minal husbandname1 husbandname1 Bhasme
//		String husbandname = "ganesh";
//		String husbandname1 = "ketan";
//		String output1 = String.format(name, husbandname1, husbandname1);
//		System.out.println(output1);
//		
		String output=String.format(deleteUrl, "1234");
		System.out.println(output); //delete1234
		
	/*	String apiBody = "{\"name\":\"Pooja Pingle\",\"salary\":\"1600000\",\"age\":\"27\"}";
		
		String response = given().log().all().header("Content-Type", "application/json").body(apiBody)
	            .when().post(createUrl)
                .then().log().all().assertThat().statusCode(200).body("data.name", equalTo("Pooja Pingle")).extract().body().asString();

		System.out.println(response);
		
		JsonPath jsonPath = new JsonPath(response);
		
		int id = jsonPath.getInt("data.id");
		
		System.out.println(String.format(putUrl, id +""));
		
		putUrl = String.format(putUrl, id);
		
		given().log().all().header("Content-Type", "application/json").body(apiBody)
	            .when().put(putUrl)
                .then().log().all().assertThat().statusCode(200).log().all();
		 
		given().log().all().header("Content-Type", "application/json")
        .when().delete(deleteUrl)
        .then().log().all().assertThat().statusCode(200).log().all();
 */
	}

}
