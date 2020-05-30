package POJO_Demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_Student {
	
	@Test
	public void testStudent() {
		School school = new School();
		school.setCapacity(50);
		school.setSchoolArea("wakad");
		school.setSchoolName("Janta high school");
		
		Student student = new Student();
		student.setAge(10);
		student.setId(99);
		student.setName("Suchita");
		student.setSchool(school);
		
		given().log().all()
		.contentType(ContentType.JSON)
		.body(student)
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then()
		.log().all();

	}

}
