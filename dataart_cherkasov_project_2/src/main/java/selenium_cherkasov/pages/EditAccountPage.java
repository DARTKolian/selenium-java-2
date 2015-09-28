package selenium_cherkasov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium_cherkasov.util.Utils;


public class EditAccountPage extends AnyPage {
	
	public EditAccountPage(PageManager pages) {
		super(pages);
		
	}

	public EditAccountPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//h1[contains(text(),'Edit account')]",pages);
		return this;
	}

	@FindBy(name= "fname")
	private WebElement firstNameField;

	@FindBy(name= "lname")
	private WebElement lastNameField;

	@FindBy(name= "currentPassword")
	private WebElement currentPasswordField;

	@FindBy(name= "password")
	private WebElement newPasswordField;

	@FindBy(name= "passwordConfirm")
	private WebElement confirmPasswordField;

	@FindBy(xpath= "//input[@value='Update']")
	private WebElement updateButton;

	public String getFirstName() {
		return firstNameField.getAttribute("value");
	}

	public String getLastName() {
		return lastNameField.getAttribute("value");
	}

	public EditAccountPage setFirstNameField(String text) {
		firstNameField.sendKeys(text);
		return this;
	}

	public EditAccountPage setLastNameField(String text) {
		lastNameField.sendKeys(text);
		return this;
	}

	public EditAccountPage setCurrentPasswordField(String text) {
		currentPasswordField.sendKeys(text);
		return this;
	}

	public EditAccountPage setNewPasswordField(String text) {
		newPasswordField.sendKeys(text);
		return this;
	}

	public EditAccountPage setConfirmPasswordField(String text) {
		confirmPasswordField.sendKeys(text);
		return this;
	}
	public EditAccountPage updateButton() {
		updateButton.click();
		return this;
	}

}