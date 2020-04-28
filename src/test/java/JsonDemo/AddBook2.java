package JsonDemo;

public class AddBook2 {
	
	public static String inputPayload() {
		return ("{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Automation using Selenium\",\r\n" + 
				"\"isbn\":\"%s\",\r\n" + 
				"\"aisle\":\"%s\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}");
	}

}
