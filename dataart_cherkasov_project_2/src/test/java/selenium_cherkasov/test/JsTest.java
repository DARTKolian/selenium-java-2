package selenium_cherkasov.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest extends selenium_cherkasov.pages.TestBase {

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
	public void getFindMeField() {
		app.getUserHelper().loginAs(ADMIN);
		app.getNavigationHelper().gotoJsTestPage();
		app.getJsHelper().getCoordinates();
	}
}		
