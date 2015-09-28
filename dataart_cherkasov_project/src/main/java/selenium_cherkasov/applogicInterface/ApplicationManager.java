package selenium_cherkasov.applogicInterface;

import selenium_cherkasov.applogicRealization.DriverBasedHelper;

public interface ApplicationManager {

	UserHelper getUserHelper();
	ApplicationHelper getApplicationHelper();
    NavigationHelper getNavigationHelper();
    AjaxHelper getAjaxHelper();
    JsHelper getJsHelper();
    DriverBasedHelper getDriverBasedHelper();

  void stop();


}
