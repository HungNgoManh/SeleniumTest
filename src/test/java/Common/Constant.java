package Common;

import net.bytebuddy.utility.RandomString;

public class Constant {

	public static String USERNAME = "hung.ngo@anki.com";
	public static String PASSWORD = "12345678";
	public static String WelcomeText = "Welcome "+ USERNAME;
	public static String LoginErrorMessage = "There was a problem with your login and/or errors exist in your form.";
	public static String LoginAttemptError = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static String RandomPassword = RandomString.make(5);
    public static String EmailContact = "mailto:thanh.viet.le@logigear.com";
    
    public static String RandomEmail = "hungw.ngomanh+" + RandomString.make(5) +"@gmail.com";
    public static String PID = "12345678";
    public static String RegisterSuccessMessage ="Thank you for registering your account";
    
 // create Generatoremail method
    public static class MessageLoginPage{
    	public static String LoginErrorMessage = "There was a problem with your login and/or errors exist in your form.";
    }
}
