package selenium_cherkasov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

	private WebDriver driver;


	public LoginPage loginPage;
	public InternalPage internalPage;
	public AjaxTestPage ajaxTestPage;
	public JsTestPage jsTestPage;
	public MyApplicationsPage myApplicationsPage;
	public NewApplicationPage newApplicationPage;
	public EditAccountPage editAccountPage;
	public ApplicationPage applicationPage;
	public RegisterNewUserPage registerNewUserPage;
	public EditApplicationPage editApplicationPage;



	public PageManager(WebDriver driver) {
		this.driver = driver;
		loginPage = initElements(new LoginPage(this));
		internalPage = initElements(new InternalPage(this));
		ajaxTestPage = initElements(new AjaxTestPage(this));
		jsTestPage = initElements(new JsTestPage(this));
		myApplicationsPage = initElements(new MyApplicationsPage(this));
		newApplicationPage = initElements(new NewApplicationPage(this));
		editAccountPage = initElements(new EditAccountPage(this));
		applicationPage = initElements(new ApplicationPage(this));
		registerNewUserPage = initElements(new RegisterNewUserPage(this));
		editApplicationPage = initElements(new EditApplicationPage(this));
	}

	private <T extends Page> T initElements(T page) {
		
		//Manually created clear expectations. Waiting the element to be visible.  
		PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
		return page;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
