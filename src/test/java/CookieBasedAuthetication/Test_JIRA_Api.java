package CookieBasedAuthetication;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Test_JIRA_Api {
	
	String createSessionURI = "/rest/auth/1/session";
	String createIssueURI = "/rest/api/2/issue/";
	String createAttachmentURI = "/rest/api/2/issue/{key}/attachments";
	String ADD_COMMENT = "/rest/api/2/issue/{key}/comment";
	
	@Test
	public void createSession() {
		
		/*Session filter : It is used for maintain the session. 
		 * Session maintain by using json cookie.
		 */
		SessionFilter sessionFilter = new SessionFilter();
		
		RestAssured.baseURI = "http://localhost:8080";
		
		//------------- Create Session -> POST method -------------------//
		String session_Response = given().log().all()
				                  .contentType(ContentType.JSON)   //or-> .header("Content-Type", "application/json")
								  .body(PayloadJira.getSessionPayload())
								  .filter(sessionFilter) //pass SessionFilter object
								  .when().post(createSessionURI)
								  .then().log().all()
								  .assertThat().statusCode(200).extract().body().asString();
				
		System.out.println("Session is: "+session_Response);
			
		String issue_Response = given().log().all()
		.contentType(ContentType.JSON)
		.body(PayloadJira.getCreateBugPayload())
		.filter(sessionFilter) //pass SessionFilter object
		.when().post(createIssueURI)
		.then().log().all()
		.assertThat().statusCode(201)
		.extract().body().asString();
		
		//--------- JIRA bug attatchment using Post method--------------//
		File fileObj = new File("E:\\restApi\\src\\test\\resources\\Test.txt");
		JsonPath js1 = new JsonPath(issue_Response);
		
		String jiraKey = js1.getString("key");
		
		given().log().all()
		.pathParam("key", jiraKey)
		.header("Content-Type","multipart/form-data")
		.header("X-Atlassian-Token","nocheck")
		.multiPart("file",fileObj)
		.filter(sessionFilter)
		.when().post(createAttachmentURI)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();
		
		
		//------------- JIRA add comment ----------//
		given().log().all().header("Content-Type", "application/json;charset=UTF-8")
		.pathParam("key",jiraKey)
		.body(PayloadJira.getAddCommentPayload())
		.filter(sessionFilter)
		.when().post(ADD_COMMENT)
		.then().log().all();
		
	}
}
