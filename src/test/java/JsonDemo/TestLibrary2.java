package JsonDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TestLibrary2 {

	@Test
	public void testLibrary() {
		// Base URL
		RestAssured.baseURI = "http://216.10.245.166";

		// endpoints related to employees

		String createUrl = "/Library/Addbook.php";

		String deleteUrl = "/Library/DeleteBook.php";

		String getBookId = "Library/%s"; //GetBook.php?ID=3389";
		
		String getBookByAuthorname = "/Library/GetBook.php?AuthorName=somename";

		//*************************** POST METHOD **************************//
		
		String isbn = "Minal";
		String aisle = "1234";
	
		String apiPostBody = String.format(AddBook2.inputPayload(), isbn,aisle );
		System.out.println(apiPostBody);
		
		String postResponse = given().log().all().header("Content-Type", "application/json").body(apiPostBody)
								  .when().post(createUrl)
									.then().log().all().assertThat().statusCode(200).extract().body().asString();
		System.out.println("Post response : "+postResponse);
		

		JsonPath js2 = new JsonPath(postResponse);
		String id = js2.getString("ID");
		String actualID = id; //Minal@1234
		System.out.println("Actual id is : "+ actualID);
		
		String expectedID = isbn+aisle;
		System.out.println(expectedID);
		Assert.assertEquals(actualID, expectedID); 
		
		//****************************** GET  METHOD **************************************//
//		JsonPath js3 = new JsonPath(postResponse);
//		String bookID = js3.getString("ID");
//		System.out.println("bookId : "+bookID);
//		
//		String getAuthor = js2.getString("author");
//		System.out.println("Author:"+getAuthor);
//		
//		bookID = "GetBook.php?ID=" + bookID;
//		String getURI = String.format(getBookId, bookID);
//		String getResponse = given().log().all().header("Content-Type", "application/json").body(AddBook2.getBook())
//							.when().get(getURI)
//								.then().log().all().extract().response().asString();
//		System.out.println("GET Response ID : "+getResponse);
//				
	}

}
