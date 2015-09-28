package selenium_cherkasov.applogicRealization;

import org.openqa.selenium.By;
import org.testng.Assert;

import selenium_cherkasov.applogicInterface.AjaxHelper;

public class AjaxHelper1 extends DriverBasedHelper implements AjaxHelper {

	public AjaxHelper1(ApplicationManager1 manager) {
		super(manager.getWebDriver());
	}

	@Override
	public void SumOK() {
		pages.ajaxTestPage
		.setXField("1")
		.setYField("2")
		.clickSumButton();
	}

	@Override
	public void SumNOTOK() {
		pages.ajaxTestPage
		.setXField("1")
		.setYField("a")
		.clickSumButton();
	}

	@Override
	public void ensureIncorrectResult() {
		String message = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(message, "Result is: Incorrect data");
	}

	@Override
	public void ensureCorrectResult() {
		String message = driver.findElement(By.id("result")).getText();
		Assert.assertNotEquals(message, "Result is: Incorrect data");
	}


}
