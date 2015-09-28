package selenium_cherkasov.pages;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;

//Awaiting of the visible locator
public class DisplayedElementLocator extends AjaxElementLocator {
	public DisplayedElementLocator(WebDriver driver, Field field, int timeOutInSeconds) {
		super(driver, field, timeOutInSeconds);
	}
	//checking of the visibility of the element
	protected boolean isElementUsable(WebElement element) {
		return element.isDisplayed();
	}
}