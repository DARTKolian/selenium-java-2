package selenium_cherkasov.applogicRealization;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_cherkasov.pages.PageManager;

public class DriverBasedHelper {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManager pages;

	public DriverBasedHelper(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		pages = new PageManager(driver);
	}

	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}

	public File takeScreenshot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	}
}
