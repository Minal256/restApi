package POJO_Assignment_30_5_20;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Serilazation_De_InPOJO.EmpResponse;
import io.restassured.RestAssured;

public class TestLibrary_30_5_2020 {

	String createUrl = "Library/Addbook.php";
	String deleteURI = "/Library/DeleteBook.php";
	String getBookbByAuthorname = "/Library/GetBook.php?AuthorName=somename";
	String getUrl = "/Library/GetBook.php?ID=%s";

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "http://216.10.245.166";
	}

	@Test
	public void addBook() {
		Input_AddBook input1 = new Input_AddBook();
		input1.setName("Ketan");
		input1.setIsbn("minalketa");
		input1.setAisle("2657527897");
		input1.setAuthor("minal");
		
	//	System.out.println(input);
		
		AddBookResponse addResponse = new AddBookResponse();
		
		addResponse	= given().log().all()
				.header("Content-Type","application/json")
				.body(input1)
				.when()
				.post(createUrl)
				.then()
				.log().all().extract().as(AddBookResponse.class);
		System.out.println( "addResponse"+addResponse);
		
//		System.out.println("msg is: "+addResponse.getMsg());
//		System.out.println("id is:" +addResponse.getId());
	}
}
