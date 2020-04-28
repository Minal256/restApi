package JsonDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ReadJsonArray {

	@Test
	public void readjson() {
		JsonPath js = new JsonPath(Payload.getCourseJson());
		int purchaseAmmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("dashboard.purchaseAmount: "+purchaseAmmount);
		
		String website = js.getString("dashboard.website");
		System.out.println("dashboard.website: "+website);
		
		//get courses of paylaod json
		String firstCourse = js.getString("courses[0].title");
		System.out.println("firstcourse: "+firstCourse);
		
		//get length of an array
		int arrayLength = js.get("courses.size()");
		System.out.println("Length of an Array is: "+arrayLength);
		
		//get one-by-one title of course
		for (int i = 0; i < arrayLength; i++) {
			String title = js.get("courses[" + i + "].title");
			System.out.println(title);
		}
		
		String firstCoursePrice = js.getString("courses[0].price");
		System.out.println("firstCoursePrice is: "+firstCoursePrice);
		
		int firstCourseCopies = js.getInt("courses[0].copies");
		System.out.println("firstCourseCopies: "+firstCourseCopies);
		
		//get price total of all courses
		int total=0;
		for (int i = 0; i < arrayLength ; i++) {
			int price = js.getInt("courses[" + i +"].price");
			total=total+price;
			System.out.println("price:"+ price);
		//	System.out.println("inner total:"+total); //Total print whenever price is added
		}
		System.out.println("Total price of all courses is: "+total);
		Assert.assertEquals(total, purchaseAmmount);
	}

}
