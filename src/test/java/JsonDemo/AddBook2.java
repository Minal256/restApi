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
	
	public static String getBook() {
		return("{\r\n" + 
				"      \"book_name\": \"Learn Rest Api using Postman\",\r\n" + 
				"      \"isbn\": \"a23hd738\",\r\n" + 
				"      \"aisle\": \"1223\"\r\n" + 
				"   } \r\n" + 
				"");
	}

}
