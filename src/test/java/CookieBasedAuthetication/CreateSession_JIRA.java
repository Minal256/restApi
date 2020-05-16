package CookieBasedAuthetication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreateSession_JIRA {

	@Test
	public void CreateSession() {
		
		RestAssured.baseURI = "http://localhost:8080";
		
		String createSessionURI = "/rest/auth/1/session";
		
		String createIssueURI = "/rest/api/2/issue/";
		
		String SessionBody = "{\r\n" + 
				"	\"username\":\"minal.bhasme256\",\r\n" + 
				"	\"password\": \"Minal@123\"\r\n" + 
				"	\r\n" + 
				"}\r\n" + 
				"";
		
		//------------- Create Session -> POST method -------------------//
		String response = given().log().all().header("Content-Type", "application/json").body(SessionBody)
						  .when().post(createSessionURI)
						  .then().assertThat().statusCode(200).extract().body().asString();
		
		System.out.println("Session is: "+response);
	
		//------------- Create issue (Bug) -> POSAT method ----------------//
		JsonPath js = new JsonPath(response);
		String sessionId = js.get("session.value"); //get it by console
		System.out.println("sessionId is: "+ sessionId);
		
		String issueBody = "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"AM\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"Minal create story by Automation.\",\r\n" + 
				"        \"description\": \"This is my first story.\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		
		String issueResponse = given().log().all().header("session.name",sessionId).body(issueBody)
				  .when().post(createIssueURI)
				  .then().assertThat().statusCode(200).extract().body().asString();
		
		System.out.println("Issue response is: "+issueResponse);
	}
	
 }

