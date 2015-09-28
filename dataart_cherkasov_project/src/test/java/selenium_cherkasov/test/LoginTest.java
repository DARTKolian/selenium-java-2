package selenium_cherkasov.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_cherkasov.model.User;

public class LoginTest extends selenium_cherkasov.pages.TestBase {

	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isLoggedIn()) {
			app.getUserHelper().logout();
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = app.getUserHelper().takeScreenshot();
			FileUtils.copyFile(scrFile, new File(screenshotPath));
		}
	}

	@Test
	public void loginAsAValidUser() throws Exception {
		User user = new User().setFirstName("Ivan").setLastName("Petrov");
		app.getUserHelper().loginAs(ADMIN);
		Assert.assertTrue(app.getUserHelper().isLoggedInAs(user));
	}

	@Test
	public void loginAsAValidUserWithIncorrectPassword() throws Exception {
		User user = new User().setUsername("admin").setPassword("wrong");
		app.getUserHelper().loginAs(user);
		Assert.assertFalse(app.getUserHelper().isLoggedIn());
	}
}