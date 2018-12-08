package Common;

import net.bytebuddy.utility.RandomString;

public class Utilities {
	
	public static String EmailGenerator () {
		
		String BaseEmail = "hung.ngo.test+";
		String EmailHost = "@gmail.com";
		String RandomEmail = BaseEmail + RandomString.make(5) + EmailHost;
		return RandomEmail;
		
	}
	
	public static String RandomPassword () {
		
		String randomPassword = RandomString.make(8);
		return randomPassword;
		
	}

}
