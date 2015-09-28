package selenium_cherkasov.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import selenium_cherkasov.util.Utils;

public class InternalPage extends AnyPage {
	
	public InternalPage(PageManager pages) {
		super(pages);
	}

	public InternalPage ensurePageLoaded() {
		super.ensurePageLoaded();
		Utils.waitUntilXpath("//a[contains(text(),'Home')]",pages);
		return this;
	}


	@FindBy(xpath = "//a[contains(text(),'Ajax test page')]")
	private WebElement ajaxTestPageLink;

	@FindBy(xpath = "//a[contains(text(),'JS test page')]")
	private WebElement jsTestPageLink;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homeLink;

	@FindBy(xpath = "//a[contains(text(),'My applications')]")
	private WebElement myApplicationsLink;

	@FindBy(xpath = "//a[contains(text(),'Edit account')]")
	private WebElement editAccountLink;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[contains(text(),'Details')]")
	private WebElement anyApplicationDetailsLink;

	@FindBys(@FindBy(xpath = "//div[@class='name']"))
	private List <WebElement> applicationTitles;


	public AjaxTestPage clickAjaxTestPage() {
		ajaxTestPageLink.click();
		return pages.ajaxTestPage;
	}

	public JsTestPage clickJSTestPage() {
		jsTestPageLink.click();
		return pages.jsTestPage;
	}

	public InternalPage clickHomePage() {
		homeLink.click();
		return this;
	}

	public MyApplicationsPage clickMyApplicationsPage() {
		myApplicationsLink.click();
		return pages.myApplicationsPage.ensurePageLoaded();
	}

	public EditAccountPage clickEditAccountPage() {
		editAccountLink.click();
		return pages.editAccountPage.ensurePageLoaded();
	}

	public LoginPage clickLogoutLink() {
		logoutLink.click();
		return pages.loginPage.ensurePageLoaded();
	}

	public ApplicationPage clickAnyApplicationDetailsLink() {
		anyApplicationDetailsLink.click();
		return pages.applicationPage.ensurePageLoaded();
	}

	public InternalPage getListOfApplicationTitles() {
		return this;
	}

	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}  
	}



}
