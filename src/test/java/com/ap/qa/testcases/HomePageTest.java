package com.ap.qa.testcases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.util.TestUtil;

/**
 * 
 * @author Chintan
 *
 */
public class HomePageTest extends TestBase {
	LoginPage loginPg = new LoginPage();
	HomePage homePg = new HomePage();
	private final static Logger LOGGER = Logger.getLogger(HomePageTest.class.getName());
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("url"));
	}

	@DataProvider
	public Object[][] getAutomationTestData() {
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}

	@Test(priority = 1, dataProvider = "getAutomationTestData")
	public void Firmex_Login(String email, String pw) throws Throwable {
		boolean flag = true;
		String title = homePg.validateHomePageTitle();
		Assert.assertEquals(title, "The World's Most Trusted Virtual Data Room | Firmex");
		captureScreenShot();
		homePg.SignInButton().click();
		LOGGER.info("Clicked On Sign In Button");
		Thread.sleep(2000);
		String title1 = loginPg.validateLoginPageTitle();
		Assert.assertEquals(title1, "Firmex Virtual Data Room Login");
		Actions actions = new Actions(driver);
		actions.moveToElement(loginPg.emailID());
		actions.click();
		if (email.equals("No Data")) {
			actions.sendKeys("");
		} else {
			actions.sendKeys(email);
		}
		actions.build().perform();
		loginPg.ClickNextButton();
		try {
			if (loginPg.MailErrorMsg().isDisplayed()) {
				flag = false;
				LOGGER.info(loginPg.MailErrorMsg().getText());
				captureScreenShot();
			}
		} catch (Exception e) {

		}
		if (flag) {
			if (pw.equals("No Data")) {
				loginPg.password().sendKeys("");
			} else {
				loginPg.password().sendKeys(pw);
			}
			loginPg.ClickLoginButton();
			LOGGER.info("Clicked On Login Button");
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

			try {
				String msg = loginPg.ErrorMsg().getText();
				if (loginPg.ErrorMsg().isDisplayed()) {
					LOGGER.info("Verified: Not able to login: " + msg);
				}
			} catch (Exception e) {
				captureScreenShot();
				LOGGER.info("Login Successfully");
				Assert.fail("User able to login successfully with invalid credentials");
			}

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
