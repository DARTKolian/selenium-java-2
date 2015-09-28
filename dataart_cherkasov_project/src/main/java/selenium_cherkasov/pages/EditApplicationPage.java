package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium_cherkasov.util.Utils;


public class EditApplicationPage extends AnyPage {

	public EditApplicationPage(PageManager pages) {
		super(pages);
	}

	public EditApplicationPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//h1[contains(text(),'Edit application')]",pages);
		return this;
	}

	@FindBy(xpath= "//textarea[@name='description']")
	private WebElement descriptionField;

	@FindBy(xpath= "//input[@value='Update']")
	private WebElement updateButton;

	public EditApplicationPage setDescriptionField(String text) {
		descriptionField.sendKeys(text);
		return this;
	}

	public EditApplicationPage clearDescriptionField() {
		descriptionField.sendKeys(Keys.CONTROL + "a");
		descriptionField.sendKeys(Keys.DELETE);
		return this;
	}

	public EditApplicationPage clickUpdateButton() {
		updateButton.click();
		//wait.until(alertIsPresent()).accept();
		wait.until(presenceOfElementLocated(By.xpath("//p[contains(text(),'Application edited')]")));
		return this;
	}	
}