package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainAppPage extends BasePage {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement mainTitleText;

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']")
    private WebElement expansesButton;

    @FindBy(xpath = "//li[@data-route='crm_business_trip_index']")
    private WebElement businessTripsButton;

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createBusinessTripsButton;

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    private WebElement loadingIcon;

    @Step("Проверка загрузки главной страницы")
    public MainAppPage checkMainTitle() {
        Assert.assertEquals("Проверка главного тайтла страницы",
                "Панель быстрого запуска", waitUtilElementToBeVisible(mainTitleText).getText());
        return this;
    }

    @Step("Переход на окно командировки")
    public MainAppPage chooseBusinessTrips() {
        waitUtilElementToBeClickable(expansesButton).click();
        waitUtilElementToBeClickable(businessTripsButton).click();
        return this;
    }

    @Step("Нажать на кнопку 'Создать командировку'")
    public BusinessTripsPage createBusinessTrip() {
        waitUtilElementToBeClickable(createBusinessTripsButton).click();
        return pageManager.getBusinessTripsPage();
    }

}
