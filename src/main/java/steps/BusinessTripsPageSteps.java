package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import managers.PageManager;

public class BusinessTripsPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Тогда("проверить, что открылась страница создания командировки")
    public void checkIfMainPageLoaded() {
        pageManager.getBusinessTripsPage().checkPageTitle();
    }

    @И("выбрать подразделение 'Отдел внутренней разработки'")
    public void chooseSubdivisionOption() {
        pageManager.getBusinessTripsPage().chooseSubdivision();
    }

    @И("^выбрать принимающую организацию$")
    public void chooseHostOrganization() {
        pageManager.getBusinessTripsPage().chooseHostOrganization();
    }

    @И("в поле Заказ билетов - отметить чекбокс")
    public void вПолеЗаказБилетовОтметитьЧекбокс() {
        pageManager.getBusinessTripsPage().clickTicketOrderCheckbox();
    }

    @И("в поле Город выбытия внести: {string}")
    public void вПолеГородВыбитияВнести(String city) {
        pageManager.getBusinessTripsPage().chooseDepartureCity(city);
    }

    @И("в поле Город прибытия внести: {string}")
    public void вПолеГородПрибытияВнести(String city) {
        pageManager.getBusinessTripsPage().chooseArrivalCity(city);
    }

    @И("в поле Планируемая дата выезда внести: {string}")
    public void вПолеПланируемаяДатаВыездаВнести(String date) {
        pageManager.getBusinessTripsPage().chooseBusinessTripDepartureDate(date);
    }

    @И("в поле Планируемая дата возвращения внести: {string}")
    public void вПолеПланируемаяДатаВозвращенияВнести(String date) {
        pageManager.getBusinessTripsPage().chooseBusinessTripReturnDate(date);
    }

    @Тогда("проверить, что выбрано подразделение {string}")
    public void проверитьЧтоВыбраноПодразделениеОтделВнутреннейРазработки(String text) {
        pageManager.getBusinessTripsPage().checkDepartmentField(text);
    }

    @Тогда("проверить, что в поле принимающего организация выбрана {string}")
    public void проверитьЧтоВПолеПринимающегоОрганизацияВыбрана(String text) {
        pageManager.getBusinessTripsPage().checkHostOrganizationField(text);
    }

    @Тогда("проверить, что выбран чекбокс Заказ билетов")
    public void проверитьЧтоВыбранЧекбоксЗаказБилетов() {
        pageManager.getBusinessTripsPage().checkTicketsOrderChosen();
    }

    @Тогда("проверить, что в поле город выбытия выбрана: {string}")
    public void проверитьЧтоВПолеГородВыбитияВыбрана(String city) {
        pageManager.getBusinessTripsPage().checkDepartureCity(city);
    }

    @Тогда("проверить, что в поле город прибытия выбран: {string}")
    public void проверитьЧтоВПолеГородПрибытияВыбран(String city) {
        pageManager.getBusinessTripsPage().checkArrivalCity(city);
    }

    @Тогда("проверить, что в поле планируемая дата выезда стоит: {string}")
    public void проверитьЧтоВПолеПланируемаяДатаВыездаСтоит(String date) {
        pageManager.getBusinessTripsPage().checkDepartureDate(date);
    }

    @Тогда("проверить, что в поле планируемая дата возвращения стоит: {string}")
    public void проверитьЧтоВПолеПланируемаяДатаВозвращенияСтоит(String date) {
        pageManager.getBusinessTripsPage().checkReturnDate(date);
    }

    @И("нажать на кнопку 'Сохранить и закрыть'")
    public void нажатьНаКнопкуСозранитьИЗакрыть() {
        pageManager.getBusinessTripsPage().clickSaveAndCloseButton();
    }

    @Тогда("проверить, что появилось сообщение об ошибке: {string}")
    public void проверитьЧтоПоявилосьСообщениеОбОшибке(String errorMessage) {
        pageManager.getBusinessTripsPage().checkValidationErrorMessage(errorMessage);
    }
}
