package selenium_cherkasov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium_cherkasov.util.Utils;


public class MyApplicationsPage extends AnyPage {

	public MyApplicationsPage(PageManager pages) {
		super(pages);
	}

	public MyApplicationsPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//a[contains(text(),'Click to add new application')]", pages);
		return this;
	}

	@FindBy(xpath= "//a[contains(text(),'Click to add new application')]")
	private WebElement addNewApplicationLink;

	@FindBy(xpath = "//div[@class='name']")
	private WebElement applicationTitle;

	@FindBy(xpath = "//a[contains(text(),'Details')]")
	private WebElement detailsLinkText;

	public NewApplicationPage clickAddNewApplicationLink() {
		addNewApplicationLink.click();
		return pages.newApplicationPage.ensurePageLoaded();
	}

	public WebElement getApplicationTitle() {
		return pages.myApplicationsPage.applicationTitle;
	}

	public ApplicationPage clickDetailsLinkText() {
		detailsLinkText.click();
		return pages.applicationPage.ensurePageLoaded();
	}

}