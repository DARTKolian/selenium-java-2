package selenium_cherkasov.util;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_cherkasov.pages.PageManager;

public class Utils {
	protected static WebDriverWait wait;
	protected static WebDriver driver;

	public  static void waitUntilXpath(String xpath,PageManager pages) {
		driver = pages.getWebDriver();
		wait= new WebDriverWait(driver, 10); 
		wait.until(presenceOfElementLocated(By.xpath(xpath)));
	}


	public static void waitUntilId(String id,PageManager pages) {
		driver = pages.getWebDriver();
		wait= new WebDriverWait(driver, 10); 
		wait.until(presenceOfElementLocated(By.xpath(id)));
		}
}
