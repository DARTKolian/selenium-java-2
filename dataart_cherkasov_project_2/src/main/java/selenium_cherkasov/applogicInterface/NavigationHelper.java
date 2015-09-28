package selenium_cherkasov.applogicInterface;

public interface NavigationHelper {

  void openMainPage();
  void openRelativeUrl(String url);
  void gotoAjaxTestPage();
  void gotoJsTestPage();
  void gotoInternalPage();
  void gotoEditAccountPage();
void gotoMyApplicationsPage();
void gotoNewApplicationsPage();
boolean NewApplicationsPageIsOpen();
boolean MyApplicationsPageIsOpen();
void gotoEditApplicationsPage();
void openPreviousPage();

}
