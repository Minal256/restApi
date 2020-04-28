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

		String getBookId = "Library/GetBook.php?ID=3389";
		
		String getBookByAuthorname = "/Library/GetBook.php?AuthorName=somename";

		//*************************** POST METHOD **************************//
		
		String isbn = "Minal";
		String aisle = "@1234";
		String apiBody = String.format(AddBook.postPayload(), isbn,aisle );
		
		String apiPostBody = String.format(AddBook2.inputPayload(), isbn,aisle );
		System.out.println(apiPostBody);
		
		String getPostresponse = given().log().all().header("Content-Type", "application/json").body(apiPostBody)
								  .when().post(createUrl)
									.then().log().all().assertThat().statusCode(200).extract().body().asString();
		System.out.println("Post response : "+getPostresponse);
		

		JsonPath js2 = new JsonPath(getPostresponse);
		String id = js2.getString("ID");
		String actualID = id; //Minal@1234
		System.out.println("Actual id is : "+ actualID);
		
		String expectedID = isbn+aisle;
		System.out.println(expectedID);
		Assert.assertEquals(actualID, expectedID); 
	}

}
