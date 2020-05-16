package CookieBasedAuthetication;

import static io.restassured.RestAssured.given;

public class Demo1 {
	public static void main(String[] args) {
		given().log().all()
		.when().get("http://www.youtube.com")
		.then().log().all();
	}

}
