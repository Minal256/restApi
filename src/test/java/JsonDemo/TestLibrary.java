package JsonDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TestLibrary {

	@Test
	public void test() {

		// Base URL
		RestAssured.baseURI = "http://216.10.245.166";

		// endpoint related to employee
		String createUrl = "Library/Addbook.php";
		String deleteURI = "/Library/DeleteBook.php";
		String getbookbbyAuthorname = "/Library/GetBook.php?AuthorName=somename";
		String getUrl = "/Library/GetBook.php?ID=%s";
		
		
/*		JsonPath js = new JsonPath(AddBook.postPayload());
		String isbn = js.get("isbn");
		System.out.println("isbn:"+isbn);
		String aisle = js.get("aisle");
		System.out.println("aisle:"+aisle);
		String actualID = isbn+aisle;
		System.out.println(actualID);  */
		
		String isbn = "Minal";
		String aisle = "1234";
		String apiBody = String.format(AddBook.postPayload(), isbn,aisle );
		
	/*	String response = given().log().all().header("Content-Type", "application/json").body(AddBook.postPayload())
		.when().post(createUrl)
		.then().log().all().assertThat().statusCode(200).extract().body().asString();
		System.out.println(response); */
		
		//************************** POST Method ********************************//
		String response = given().log().all().header("Content-Type", "application/json").body(apiBody)
				.when().post(createUrl)
				.then().log().all().assertThat().statusCode(200).extract().body().asString();
				System.out.println(response);

		JsonPath js2 = new JsonPath(response);
		String id = js2.getString("ID");
		String actualID = id; //Minal1234
		System.out.println("Actual id is : "+ actualID);
		
		String expectedID = isbn+aisle;
		System.out.println(expectedID);
		Assert.assertEquals(actualID, expectedID); 
		
		//************************** GET Method *********************************//
//		
//		String idFromGetUrl = String.format(getUrl, id+"" );
//		System.out.println("GET ID FROM URL"+idFromGetUrl);
//		
//		String get_Response = given().log().all().header("Content-Type", "application/json")
//				.when().get(idFromGetUrl)
//				.then().log().all().assertThat().statusCode(200).extract().body().asString();
//		System.out.println(get_Response);
//				
		//*********************** DELETE Method *************************************//
		
//		String apiDeleteBody="{\r\n" + 
//					"\"ID\" : \""+id+"\"\r\n" + 
//					" \r\n" + 
//					"}";
//		
////		String apiBody_Delete = String.format(AddBook.deleteBook(), actualID);
////		System.out.println("delete_Body"+apiBody_Delete);
//		
//		given().log().all().header("Content-Type", "application/json").body(apiDeleteBody)
//				.when().post(deleteURI)
//				.then().log().all().statusCode(200).extract().body().asString();
//				
//	//	System.out.println("Delete response: "+delete_Response);	
								
	}
}
