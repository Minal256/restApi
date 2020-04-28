package JsonDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class FirstTest {
	
	@Test
	 public void firstTest() {
		 //Base URL
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        //endpoints related to employees

        String createURL = "/create";

        String deleteUrl = "/delete/{id}";

        String getAllEmployeesUrl = "/employees";

        //API Body
        String apiBody = "{\"name\":\"Raghu233120\",\"salary\":\"600000\",\"age\":\"28\"}";

        given().log().all().header("Content-Type", "application/json").body(apiBody)
                .when().post(createURL)
                        .then().log().all().assertThat().statusCode(200);


       String response = "{\n" +
               "    \"status\": \"success\",\n" +
               "    \"data\": {\n" +
               "        \"name\": \"Raghu233120\",\n" +
               "        \"salary\": \"600000\",\n" +
               "        \"age\": \"28\",\n" +
               "        \"id\": 64\n" +
               "    }\n" +
               "}";

//        JsonPath js = new JsonPath(response);
//        int outputIdFromJSPath = js.getInt("data.id");
//        String nameFromResponse = js.getString("data.name");
//        System.out.println("Output for name is -> "+nameFromResponse);
//        System.out.println("Output for id is -> "+ outputIdFromJSPath);


		
		JsonPath js2 = new JsonPath(Payload.getCourseJson());
		
		int ammount = js2.getInt("dashboard.purchaseAmount");
		System.out.println(ammount);
		
//		String zerothElementCourse = js.getString("Courses[0].title");
//		System.out.println(zerothElementCourse + "zerothElementCourse");
	}

}
