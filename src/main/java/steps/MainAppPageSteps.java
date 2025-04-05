package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class MainAppPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @И("нажать на вкладку 'Расходы' и выбрать поле 'Командировки'")
    public void chooseExpensesTabAndClickBusinessTripBtn() {
        pageManager.getMainAppPage().chooseBusinessTrips();
    }

    @И("нажать на кнопку 'Создать командировку'")
    public void clickCreateBusinessTripButton() {
        pageManager.getMainAppPage().createBusinessTrip() ;
    }
}
