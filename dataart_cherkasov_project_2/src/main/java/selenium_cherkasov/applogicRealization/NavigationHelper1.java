package selenium_cherkasov.applogicRealization;

import org.openqa.selenium.By;

import selenium_cherkasov.applogicInterface.NavigationHelper;

public class NavigationHelper1 extends DriverBasedHelper implements NavigationHelper {

	private String baseUrl;

	public NavigationHelper1(ApplicationManager1 manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}

	@Override
	public void openMainPage() {
		driver.get(baseUrl);
	}

	@Override
	public void openRelativeUrl(String url) {
		driver.get(baseUrl + url);
	}


	@Override
	public void gotoAjaxTestPage() {
		driver.findElement(By.xpath("//a[contains(text(),'Ajax test page')]"))
		.click();
	}

	@Override
	public void gotoJsTestPage() {
		driver.findElement(By.xpath("//a[contains(text(),'JS test page')]"))
		.click();
	}

	@Override
	public void gotoInternalPage() {
		driver.findElement(By.xpath("//a[contains(text(),'Home')]"))
		.click();
	}

	@Override
	public void gotoMyApplicationsPage() {
		driver.findElement(By.xpath("//a[contains(text(),'My applications')]"))
		.click();
	}

	@Override
	public void gotoNewApplicationsPage() {
		driver.findElement(By.xpath("//a[contains(text(),'My applications')]"))
		.click();
		pages.myApplicationsPage.ensurePageLoaded();
		driver.findElement(By.xpath("//a[contains(text(),'Click to add new application')]"))
		.click();
		pages.newApplicationPage.ensurePageLoaded();
	}

	@Override
	public void gotoEditAccountPage() {
		driver.findElement(By.xpath("//a[contains(text(),'Edit account')]"))
		.click();
	}

	@Override
	public void gotoEditApplicationsPage() {
		driver.findElement(By.xpath("//a[contains(text(),'My applications')]"))
		.click();
		driver.findElement(By.xpath("//a[contains(text(),'Details')]"))
		.click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]"))
		.click();
	}

	@Override
	public boolean NewApplicationsPageIsOpen() {
		return pages.newApplicationPage.waitPageLoaded();
	}

	@Override
	public boolean MyApplicationsPageIsOpen() {
		return pages.myApplicationsPage.waitPageLoaded();
	}

	@Override
	public void openPreviousPage() {
		driver.navigate().back();
	}

}