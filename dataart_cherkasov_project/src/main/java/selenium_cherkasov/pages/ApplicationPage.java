package selenium_cherkasov.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import selenium_cherkasov.util.Utils;


public class ApplicationPage extends AnyPage {
	

	public ApplicationPage(PageManager pages) {
		super(pages);
	}

	public ApplicationPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//div[contains(text(),'Author')]", pages);
		return this;
	}

	@FindBy(xpath= "//a[contains(text(),'Download')]")
	private WebElement downloadButton;

	@FindBy(xpath= "//a[contains(text(),'Delete')]")
	private WebElement deleteButton;

	@FindBy(xpath= "(//div[@class='edit-app-button']//a[contains(text(),'Edit')]")
	private WebElement editButton;

	@FindBy(name= "save")
	private WebElement saveField;


	public ApplicationPage clickDeleteButton() {
		deleteButton.click();		
		wait.until(alertIsPresent());
		Assert.assertEquals("Do you want to delete this application?", driver.switchTo().alert().getText());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		wait.until(presenceOfElementLocated(By.xpath("//p[contains(text(),'Deleted')]")));
		return this;
	}

	public EditAccountPage clickEditButton() {
		editButton.click();
		return pages.editAccountPage.ensurePageLoaded();
		
	}

	public void clickDownloadButton() {
		downloadButton.click();
	}
}