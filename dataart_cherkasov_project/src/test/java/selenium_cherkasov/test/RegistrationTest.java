package selenium_cherkasov.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTest extends selenium_cherkasov.pages.TestBase {

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
	public void registerNewUserAndVerifyThatItIsLoggedIn() {

		app.getUserHelper().createUser(USER);
		Assert.assertTrue(app.getUserHelper().isLoggedInAs(USER));
	}

	@Test
	public void registerNewUserLogoutAndVerifyThatUserCanLogin() {

		app.getUserHelper().createUser(USER);
		app.getUserHelper().logout();
		app.getUserHelper().loginAs(USER);
		Assert.assertTrue(app.getUserHelper().isLoggedInAs(USER));
	}

	@Test
	public void registerAsDeveloperVerifyThatUserCanOpenPageToUploadApplication() {

		app.getUserHelper().createUser(DEVELOPER);
		app.getNavigationHelper().gotoNewApplicationsPage();
		Assert.assertTrue(app.getNavigationHelper().NewApplicationsPageIsOpen());
	}

	@Test
	public void registerAsRegularUserVerifyThatUserCanSeeApplicationsButCannotUploadThem() {

		app.getUserHelper().createUser(USER);
		app.getNavigationHelper().gotoInternalPage();
		Assert.assertFalse(app.getUserHelper().isElementPresent(By.xpath("//a[contains(text(),'My applications')]")));
	}
}