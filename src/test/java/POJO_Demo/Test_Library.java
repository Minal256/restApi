package POJO_Demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Test_Library {

	@Test
	public void testLibrary() {
		
		given().log().all()
		.body(AddBook.inputPayload())
		.post("http://216.10.245.166/Library/Addbook.php")
		.then()
		.log().all();

	}
}
