package CookieBasedAuthetication;

public class PayloadJira {
	
	public static String getSessionPayload() {
		return "{" +
				"	\"username\":\"minal.bhasme256\","+ 
				"	\"password\": \"Minal@123\"" + 
				"}";
	}
	
	public static String getCreateBugPayload() {
		return "{" + 
				"    \"fields\": {" + 
				"        \"project\": {" + 
				"            \"key\": \"AM\"" + 
				"        }," + 
				"        \"summary\": \"My second Bug created while i was About us page.\"," + 
				"        \"description\": \"I am Minal and i reproduse this issue.\"," + 
				"        \"issuetype\": {" + 
				"            \"name\": \"Bug\"" + 
				"        }" + 
				"    }" + 
				"}";

	} 
	
	public static String getCreateStoryPayload() {
			return "{" + 
					"    \"fields\": {" + 
					"       \"project\":" + 
					"       {" + 
					"          \"key\": \"AM\"" + 
					"       },\r\n" + 
					"       \"summary\": \"My First Story in Jira through Automation\"," + 
					"       \"description\": \"I would like to share my story on Amazon site. \"," + 
					"       \"issuetype\": {" + 
					"          \"name\": \"Story\"" + 
					"       }" + 
					"   }" + 
					"}" + 
					"";
			
		}

	  public static String getAddCommentPayload(){
	        return "{\"body\": \"This is a comment regarding to Amazon home page. From Minal\"}";
	    }



}
