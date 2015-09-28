package selenium_cherkasov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import selenium_cherkasov.util.Utils;


public class NewApplicationPage extends AnyPage {

	public NewApplicationPage(PageManager pages) {
		super(pages);
	}

	public NewApplicationPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//h1[contains(text(),'New application')]", pages);
		return this;
	}

	@FindBy(name= "title")
	private WebElement titleField;

	@FindBy(name= "description")
	private WebElement descriptionField;


	private Select categoryDropdown() {
		return new Select(driver.findElement(By.xpath("//select[@name='category']")));
	}

	@FindBy(name= "image")
	private WebElement imageLoader;

	@FindBy(name= "icon")
	private WebElement iconLoader;

	@FindBy(xpath= "//input[@value='Create']")
	private WebElement createButton;

	public NewApplicationPage setTitleField(String text) {
		titleField.sendKeys(text);
		return this;
	}

	public NewApplicationPage setDescriptionField(String text) {
		descriptionField.sendKeys(text);
		return this;
	}


	public NewApplicationPage setImage(String text) {
		imageLoader.sendKeys(text);
		return this;
	}

	public NewApplicationPage setIcon(String text) {
		iconLoader.sendKeys(text);
		return this;
	}

	public static String getFolder(){
		return System.getProperty("user.dir");
	}

	public NewApplicationPage setCategory(String valueToSelect) {
		System.out.println("Value = " + categoryDropdown().getFirstSelectedOption().getText());
		categoryDropdown().selectByValue(valueToSelect);
		return this;
	}

	public NewApplicationPage clickCreateButton() {
		createButton.click();
		return this;
	}

}