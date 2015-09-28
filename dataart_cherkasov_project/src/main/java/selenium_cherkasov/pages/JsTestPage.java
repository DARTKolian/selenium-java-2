package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import selenium_cherkasov.util.Utils;


public class JsTestPage extends AnyPage {


	public JsTestPage(PageManager pages) {
		super(pages);
	}

	public JsTestPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilId("process", pages);
		return this;
	}

	@FindBy(id= "top")
	private WebElement topField;

	@FindBy(id= "left")
	private WebElement leftField;

	@FindBy(id= "process")
	private WebElement processButton;

	@FindBy(xpath= "html/body/div[1]")
	private WebElement findMeField;

	public JsTestPage setTopField(String text) {
		topField.sendKeys(text);
		return this;
	}

	public JsTestPage setLeftField(String text) {
		leftField.sendKeys(text);
		return this;
	}


	public String getTopFindMeField() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Double d = (Double) jse.executeScript("return $('.flash').position().top");
		long topField = Math.round(d);
		return Long.toString(topField);
	}

	public String getLeftFindMeField() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Double d = (Double) jse.executeScript("return $('.flash').position().left");
		long leftField = Math.round(d);
		return Long.toString(leftField);
	}



	public JsTestPage clickProcessButton() {
		processButton.click();
		wait.until(alertIsPresent());
		Assert.assertEquals("Whoo Hoooo! Correct!", driver.switchTo().alert().getText());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}

}
