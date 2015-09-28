package selenium_cherkasov.applogicRealization;


import selenium_cherkasov.applogicInterface.JsHelper;

public class JsHelper1 extends DriverBasedHelper implements JsHelper {

	public JsHelper1(ApplicationManager1 manager) {
		super(manager.getWebDriver());
	}

	@Override
	public void getCoordinates() {
		pages.jsTestPage.setTopField(pages.jsTestPage.getTopFindMeField());
		pages.jsTestPage.setLeftField(pages.jsTestPage.getLeftFindMeField());
		pages.jsTestPage.clickProcessButton();
	}

}
