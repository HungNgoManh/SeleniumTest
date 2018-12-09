package testcase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Common.Constant;
import pages.LoginPage;
import pages.RegisterPage;

public class TestBase {

	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Constant.URLTest);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
