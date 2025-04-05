package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import managers.DriverManager;
import managers.PageManager;
import managers.TestPropManager;

import static utils.PropConst.BASE_URL;

public class LoginPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Дано("авторизироваться в сервисе")
    public void userAuthorization() {
        DriverManager.getDriverManager().getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
        pageManager.getLoginPage().userAuthorization();
    }

    @Тогда("проверить, что загрузилась главная страница")
    public void checkIfMainPageLoaded() {
        pageManager.getMainAppPage().checkMainTitle();
    }
}
