package testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Common.Constant;
import pages.LoginPage;
import pages.RegisterPage;

//test commit

public class LoginAndRegisterTest {
	WebDriver driver;
	LoginPage objLogin;
	RegisterPage objRegister;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// dua vo constant
		driver.get("http://logigearrailway.somee.com/Page/HomePage.cshtml");
		driver.manage().window().maximize();
	}

	@Test(description = "Test Login success with correct welcome message", priority=1)
	public void TC01() {
		// Step
		objLogin = new LoginPage(driver);
		// Click Login tab
		objLogin.clickLoginTab();
		// login to application
		objLogin.Login(Constant.USERNAME, Constant.PASSWORD);
		// Verify welcome message is correct
		AssertJUnit.assertEquals(Constant.WelcomeText, objLogin.GetWelcomeText());
	}

	@Test(description = "Test Login with blank user name", priority=5)

	public void TC02() {
		
		objLogin = new LoginPage(driver);
		objLogin.clickLoginTab();
		objLogin.Login("", Constant.PASSWORD);
		AssertJUnit.assertEquals(Constant.MessageLoginPage.LoginErrorMessage, objLogin.GetLoginErrorMessage());

	}

	@Test(description = "Test Login with invalid password", priority=4)

	public void TC03() {

		objLogin = new LoginPage(driver);
		objLogin.clickLoginTab();
		objLogin.Login(Constant.USERNAME, Constant.RandomPassword);
		AssertJUnit.assertEquals(Constant.LoginErrorMessage, objLogin.GetLoginErrorMessage());

	}

	@Test(description = "Test Contact Email contains correct href value", priority=3)

	public void TC04() {
		objLogin = new LoginPage(driver);
		objLogin.clickContactTab();
		AssertJUnit.assertEquals(Constant.EmailContact, objLogin.GetEmailContact());

	}

	@Test(description = "Check Login attempts error - more than 3 times", priority=6)

	public void TC05() {
		objLogin = new LoginPage(driver);
		objLogin.clickLoginTab();
		
		//Step
		objLogin.LoginMultiTime(Constant.USERNAME, Constant.RandomPassword, 4);
		
		//Verify: sdas
		AssertJUnit.assertEquals(Constant.LoginAttemptError, objLogin.GetLoginErrorMessage());

	}

	@Test(description = "Check if Additional pages display once user logged in", priority=2)

	public void TC06() {
		objLogin = new LoginPage(driver);
		objLogin.clickLoginTab();
		objLogin.Login(Constant.USERNAME, Constant.PASSWORD);
		AssertJUnit.assertEquals(objLogin.getTab("Log out").isDisplayed(), "Tab Log out is not displayed");
		AssertJUnit.assertEquals(objLogin.getTab("Change password").isDisplayed(), "Tab Change password is not displayed");
		AssertJUnit.assertEquals(objLogin.getTab("My ticket").isDisplayed(), "Tab My Ticket is not displayed");
		
	}

	@Test (description = "Check if user can create new account", priority=0)

	public void TC07() {

		objRegister = new RegisterPage(driver);
		objRegister.clickRegisterTab();
		objRegister.RegisterNewUser(Constant.RandomEmail, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
		AssertJUnit.assertEquals(Constant.RegisterSuccessMessage, objRegister.GetRegisterSuccessMessage());

	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}