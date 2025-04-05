package pages;

import io.qameta.allure.Step;
import managers.TestPropManager;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.PropConst.LOGIN;
import static utils.PropConst.PASSWORD;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordField;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @Step("Авторизация")
    public MainAppPage userAuthorization() {
        waitUtilElementToBeVisible(usernameField).sendKeys(TestPropManager.getTestPropManager().getProperty(LOGIN));
        waitUtilElementToBeVisible(passwordField).sendKeys(TestPropManager.getTestPropManager().getProperty(PASSWORD));
        waitUtilElementToBeClickable(submitButton).click();
        return pageManager.getMainAppPage();
    }

}