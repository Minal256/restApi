package POJO_Demo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_DmartList {
	
	@Test
	public void testDmartList() {
		
		Kitchen kitchen = new Kitchen();
		kitchen.setDaal("5KG");
		kitchen.setRice("10KG");
		
		Soap soap1 = new Soap();
		soap1.setName("Pears");
		soap1.setPrice("50");
		
		Soap soap2 = new Soap();
		soap2.setName("Medimix");
		soap2.setPrice("35");
		
		Soap soap3 = new Soap();
		soap3.setName("Moti");
		soap3.setPrice("60");
		
		Soap soap4 = new Soap();
		soap4.setName("Lux");
		soap4.setPrice("20");
		
		List<Soap> soapList = new ArrayList<Soap>();
		soapList.add(soap1);
		soapList.add(soap2);
		soapList.add(soap3);
		soapList.add(soap4);
		
		DmartList dm = new DmartList();
		dm.setBudget("10000");
		dm.setMonth("May");
		dm.setKitchen(kitchen);
		dm.setSoap(soapList);
		
		given().log().all()
		.contentType(ContentType.JSON)
		.body(dm)
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then()
		.log().all();
	}

}
