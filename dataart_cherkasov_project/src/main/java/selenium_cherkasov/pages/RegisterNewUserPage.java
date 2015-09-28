package selenium_cherkasov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import selenium_cherkasov.util.Utils;

public class RegisterNewUserPage extends AnyPage {

	public RegisterNewUserPage (PageManager pages) {
		super(pages);
	}


	public RegisterNewUserPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//h1[contains(text(),'Fill this form to register.')]", pages);
		return this;
	}

	@FindBy(name= "name")
	private WebElement nameField;

	@FindBy(name= "fname")
	private WebElement firstNameField;

	@FindBy(name= "lname")
	private WebElement lastNameField;

	@FindBy(name= "password")
	private WebElement passwordField;

	@FindBy(name= "passwordConfirm")
	private WebElement passwordConfirmField;

	private Select roleDropdown() {
		return new Select(driver.findElement(By.name("role")));
	}

	@FindBy(xpath= "//input[@value='Register']")
	private WebElement registerButton;

	public RegisterNewUserPage setNameField(String text) {
		nameField.sendKeys(text);
		return this;
	}

	public RegisterNewUserPage setFirstNameField(String text) {
		firstNameField.sendKeys(text);
		return this;
	}

	public RegisterNewUserPage setLastNameField(String text) {
		lastNameField.sendKeys(text);
		return this;
	}

	public RegisterNewUserPage setPasswordField(String text) {
		passwordField.sendKeys(text);
		return this;
	}

	public RegisterNewUserPage setPasswordConfirmField(String text) {
		passwordConfirmField.sendKeys(text);
		return this;
	}

	public RegisterNewUserPage setRole(String valueToSelect) {
		roleDropdown().selectByValue(valueToSelect);
		return this;
	}

	public InternalPage clickRegisterButton() {
		registerButton.click();
		return pages.internalPage;
	}
}
