package POJO_Demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestAddBook {

	@Test
	public void testBook() {
		Book book = new Book();
		book.setBookName("Selenium webdriver with Node");
		book.setIsbn("MKP");
		book.setAisle(2711);
		book.setAuthorName("Mr. Paul Waston");
		
		given().log().all()
		.contentType(ContentType.JSON)
		.body(book)
		.post("http://216.10.245.166/Library/Addbook.php")
		.then()
		.log().all();


	}
	
}
