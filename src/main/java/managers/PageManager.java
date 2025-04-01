package managers;

import pages.BusinessTripsPage;
import pages.LoginPage;
import pages.MainAppPage;

public class PageManager {

    private static PageManager pageManager;
    private LoginPage loginPage;
    private MainAppPage mainAppPage;
    private BusinessTripsPage businessTripsPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainAppPage getMainAppPage() {
        if (mainAppPage == null) {
            mainAppPage = new MainAppPage();
        }
        return mainAppPage;
    }

    public BusinessTripsPage getBusinessTripsPage() {
        if (businessTripsPage == null) {
            businessTripsPage = new BusinessTripsPage();
        }
        return businessTripsPage;
    }

}
