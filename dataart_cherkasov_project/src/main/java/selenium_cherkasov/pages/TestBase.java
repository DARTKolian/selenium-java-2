package selenium_cherkasov.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import selenium_cherkasov.applogicInterface.ApplicationManager;
import selenium_cherkasov.applogicRealization.ApplicationManager1;
import selenium_cherkasov.model.Application;
import selenium_cherkasov.model.User;


public class TestBase {


	public static String getFolder(){
		return System.getProperty("user.dir");
	}

	public final static String imagePath = getFolder() + "\\bigheight401.jpg";
	public final static String iconPath = getFolder() + "\\bigheight401.jpg";

	public static String screenshotPath = getFolder() + "\\screenshots\\" + "\\screenshot_" + System.currentTimeMillis() + ".png";
	
	public static User ADMIN = new User().userLogin("admin", "admin");
	public static User USER = new User().userRegister("user" + System.currentTimeMillis(), "Sidor", "Sidorivich", "password", "USER");
	public static User DEVELOPER = new User().userRegister("user" + System.currentTimeMillis(), "Petr", "Petrovich", "password", "DEVELOPER");
	public static Application APPLICATIONWITHOUTIMAGE = new Application().setTitle("Application" + System.currentTimeMillis()).setDescription("This is no image test");
	public static Application APPLICATIONWITHIMAGE = new Application().setTitle("Application" + System.currentTimeMillis()).setDescription("This is test with image").setImage(imagePath).setIcon(iconPath);

	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager1();
	}
	@AfterSuite
	public void stop() {
		app.stop();
	}


}
