package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button/span[text()='Каталог']")
    private WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Цена']//ancestor::section//input[contains(@class, 'RangeSelector_input') and @name='min']")
    private WebElement minPriceRangeInput;

    @FindBy(xpath = "//span[contains(@class, 'PaginationViewChanger')]")
    private WebElement paginationCounterViewer;

    @FindBy(xpath = "//div[contains(@class, 'CardText_title')]")
    private WebElement firstProductNameText;

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement searchBarInput;

    public MainPage clickOnCatalogButton() {
        waitUtilElementToBeClickable(catalogButton).click();
        return pageManager.getMainPage();
    }

    public MainPage chooseMainCategoryFromCatalog(String mainCategoryChoose) {
        driverManager.getDriver().findElement(By.xpath("//div[text()='" + mainCategoryChoose + "']")).click();
        return pageManager.getMainPage();
    }

    public MainPage chooseSubCategoryFromMainCategory(String subCategoryChoose) {
        waitingUpdatingSearch();
        driverManager.getDriver().findElement(By.xpath(
                "//p[contains(@class, 'CardCategory') and text()='" + subCategoryChoose + "']")).click();
        return pageManager.getMainPage();
    }

    public MainPage fillMinPriceRange(String price) {
        waitUtilElementToBeClickable(minPriceRangeInput).clear();
        waitUtilElementToBeClickable(minPriceRangeInput).sendKeys(price);
        return pageManager.getMainPage();
    }

    public MainPage chooseGigabyteLabelOption(String manufactoryName) {
        waitingUpdatingSearch();
        driverManager.getDriver().findElement(By.xpath(
                "//label[text()='" + manufactoryName + "']")).click();
        return pageManager.getMainPage();
    }

    public MainPage waitingUpdatingSearch() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        return pageManager.getMainPage();
    }

    public Boolean checkSearchProductsPaginationNumber() {
        waitUtilElementToBeVisible(paginationCounterViewer).getText().contains("24");
        return waitUtilElementToBeVisible(paginationCounterViewer).getText().contains("24");
    }

    public String getFirstProductName() {
        return waitUtilElementToBeVisible(firstProductNameText).getText();
    }

    public MainPage fillSearchBarWithText(String text) {
        waitUtilElementToBeVisible(searchBarInput).clear();
        waitUtilElementToBeVisible(searchBarInput).sendKeys(text + "\n");
        waitingUpdatingSearch();
        return pageManager.getMainPage();
    }

    public Integer checkIfElementIsSingle() {
        List<WebElement> numberOfWebElements = driverManager.getDriver()
                .findElements(By.xpath("//div[contains(@class, 'ListingRenderer_listingCard')]"));
        return numberOfWebElements.size();
    }
}