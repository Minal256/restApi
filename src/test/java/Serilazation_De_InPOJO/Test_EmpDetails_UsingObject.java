package Serilazation_De_InPOJO;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_EmpDetails_UsingObject {

	@Test
	public void testEmp() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		String createURL = "/create";
		
		EmpDetails empDetails = new EmpDetails();
		empDetails.setEmpName("Minal Bhasme");
		empDetails.setAge("25");
		empDetails.setSalary("70000");
		
		EmpResponse empResponse = new EmpResponse();
		
		empResponse	= given().log().all()
				.header("Content-Type","application/json")
				.body(empDetails)
				.when()
				.post(createURL)
				.then()
				.log().all().extract().as(EmpResponse.class);
		
		System.out.println("Status is : "+empResponse.getStatus());
		System.out.println("Emp id is :"+empResponse.getData().getId());
		System.out.println("Emp salary is "+empResponse.getData().getSalary());
	
	}
}
