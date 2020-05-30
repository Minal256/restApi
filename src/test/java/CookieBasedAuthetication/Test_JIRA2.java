package CookieBasedAuthetication;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

	public class Test_JIRA2 {

		private String createSessionURI = "/rest/auth/1/session";
		private String createIssueURI = "/rest/api/2/issue";
		private String createAttachemntURI = "/rest/api/2/issue/%s/attachments";
		private String ADD_COMMENT = "/rest/api/2/issue/{key}/comment";
		private String ISSUE_DETAILS = "/rest/api/2/issue/{key}";

		// Response Variables
		String createSessionResponse;
		String createIssueResponse;

		// Create Object for SessionFilter
		SessionFilter sessionFilter = new SessionFilter();

		@BeforeTest
		public void setup() {
			RestAssured.baseURI = "http://localhost:8080";
		}

		@Test(priority = 1)
		public void createSession() {
			//--------Create Session -> JIRA API  POST Method -----------//
				createSessionResponse = given().log().all()
										.contentType(ContentType.JSON)
										.body(PayloadJira.getSessionPayload())
										.filter(sessionFilter).when()
										.post(createSessionURI)
										.then().log()
										.all().assertThat().statusCode(200).extract().body().asString();
			}
	
			@Test(priority = 2)
			public void createIssue() {
				//----------- Create Issue (Bug)-> JIRA API using POST Method -----------//
				createIssueResponse =  given().log().all()
										.contentType(ContentType.JSON)
										.body(PayloadJira.getCreateStoryPayload())
										.filter(sessionFilter)
										.when().post(createIssueURI)
										.then().log().all()
										.assertThat().statusCode(201)
										.extract().body().asString();
		}

		@Test(priority = 3)
		public void createAttachment() {
			
			//--------- JIRA attatchment using POST Method--------------//
			JsonPath js = new JsonPath(createIssueResponse);
			
			String getStorykey = js.get("key");
			System.out.println(getStorykey);
			
			String AttachemntURI = String.format(createAttachemntURI, getStorykey); //%s -> StoryKey
			System.out.println(createAttachemntURI);

			File fileObject = new File("E:\\restApi\\src\\test\\resources\\Color.txt");

			//---- Create Attachment -----// 
			given().log().all()
			.header("contentType", "multipart/form-data")
			.header("X-Atlassian-Token", "nocheck")
			.multiPart("file", fileObject)
			.filter(sessionFilter)
			.when().post(AttachemntURI)
			.then().log().all()
			.assertThat().statusCode(200).extract().body().asString();
		}
		
		@Test(priority = 4)
		public void addComment() {
			
			JsonPath js1 = new JsonPath(createIssueResponse);
			
			String getStorykey = js1.get("key");
			System.out.println(getStorykey);
			
//			String comment = String.format(ADD_COMMENT, getStorykey);
//			System.out.println(comment);
			
			//------------- JIRA add comment ----------//
			given().log().all().header("Content-Type", "application/json;charset=UTF-8")
			.pathParam("key",getStorykey)
			.body(PayloadJira.getAddCommentPayload())
			.filter(sessionFilter)
			.when().post(ADD_COMMENT)
			.then().log().all();
		}
		
		//---------------- field comment ------------------------//
		@Test(priority = 5)
		public void getSpecificDelaitsFromTicket() {
			JsonPath js2 = new JsonPath(createIssueResponse);
			
			String getStorykey = js2.get("key");
			System.out.println(getStorykey);
			
			given().log().all().filter(sessionFilter)
			.queryParam("fields", "attachment")
			.pathParam("key", getStorykey)
			.when().get(ISSUE_DETAILS)
			.then().log().all()
			.assertThat().statusCode(200);
		}

	}

