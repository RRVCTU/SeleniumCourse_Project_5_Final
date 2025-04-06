package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import managers.DriverManager;
import managers.PageManager;
import managers.TestPropManager;
import org.junit.Assert;

import static utils.PropConst.BASE_URL;

public class MainPageSteps {

    PageManager pageManager = PageManager.getPageManager();
    String firstProductForSearch;

    @Дано("Зайти на страницу магазина Регард")
    public void зайтиНаСтраницуМагазинаРегард() {
        DriverManager.getDriverManager().getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @И("Открыть меню Каталог")
    public void открытьМенюКаталог() {
        pageManager.getMainPage().clickOnCatalogButton();
    }

    @И("^Выбрать раздел \"([^\"]*)\"$")
    public void выбратьРазделВКатегориях(String mainCategoryChoose) {
        pageManager.getMainPage().chooseMainCategoryFromCatalog(mainCategoryChoose);
    }

    @И("В открывшемся окне выбрать раздел \"([^\"]*)\"$")
    public void выбратьРазделВОткрывшемсяОкне(String subCategoryChoose) {
        pageManager.getMainPage().chooseSubCategoryFromMainCategory(subCategoryChoose);
    }

    @И("Задать параметр поиска по цене от {} рублей")
    public void задатьПараметрПоискаПоЦенеОтРублей(String price) {
        pageManager.getMainPage().fillMinPriceRange(price);
    }

    @И("Выбрать производителя {}")
    public void выбратьПроизводителя(String manufactoryName) {
        pageManager.getMainPage().chooseGigabyteLabelOption(manufactoryName);
    }

    @И("Дождаться выполнения поиска")
    public void дождатьсяВыполненияПоиска() {
        pageManager.getMainPage().waitingUpdatingSearch();
    }

    @Тогда("Проверить, что в поисковой выдаче не более 24 товаров")
    public void проверитьЧтоВПоисковойВыдачеНеБолее24Товаров() {
        Assert.assertTrue("Количество элементов в выдаче, не более 24",
                pageManager.getMainPage().checkSearchProductsPaginationNumber());
    }

    @И("Сохранить наименование первого товара в списке")
    public void сохранитьНаименованиеПервогоТовараВСписке() {
        firstProductForSearch = pageManager.getMainPage().getFirstProductName();
    }

    @И("В поисковую строку ввести запомненное значение, выполнить поиск")
    public void вПоисковуюСтрокуВвестиЗапомненноеЗначениеВыполнитьПоиск() {
        pageManager.getMainPage().fillSearchBarWithText(firstProductForSearch);
    }

    @Тогда("Проверить, что в поисковой выдаче не более 1 товара")
    public void проверитьЧтоВПоисковойВыдачеНеБолее1Товара() {
        int numberOfVideoCards = pageManager.getMainPage().checkIfElementIsSingle();
        Assert.assertEquals("Проверка, что после поиска виден только один товар",
                1, numberOfVideoCards);
    }

    @Тогда("Проверить, что наименование товара соответствует сохраненному значению")
    public void проверитьЧтоНаименованиеТовараСоответствуетСохраненномуЗначению() {
        Assert.assertEquals("Проверка, что наименование товара соответствует сохраненному значению",
                firstProductForSearch, pageManager.getMainPage().getFirstProductName());
    }
}
