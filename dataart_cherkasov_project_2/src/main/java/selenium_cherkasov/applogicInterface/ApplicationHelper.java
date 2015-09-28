package selenium_cherkasov.applogicInterface;

import selenium_cherkasov.model.Application;

public interface ApplicationHelper {

	void create(Application application);
	void delete();
	boolean isApplicationExist(Application application);
	boolean myApplicationsPageIsLoaded();
	void Edit(Application application);
	void createWithImage(Application application);
	void downloadAppJson();
	void gotoApplicationDetails(Application application);
	boolean downloadApplicationManyTimes(Application application);
	
	
	

}
