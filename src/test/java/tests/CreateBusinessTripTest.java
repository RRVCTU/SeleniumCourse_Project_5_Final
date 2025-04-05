package tests;

import basetestsclass.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class CreateBusinessTripTest extends BaseTests {

    @Test
    @DisplayName("Проверка создания командировки")
    public void startTest() {
        app.getLoginPage()
                .userAuthorization()
                .checkMainTitle()
                .chooseBusinessTrips()
                .createBusinessTrip()
                .checkPageTitle()
                .chooseSubdivision()
                .chooseHostOrganization()
                .clickTicketOrderCheckbox()
                .chooseDepartureCity("Казань")
                .chooseArrivalCity("Ярославль")
                .chooseBusinessTripDepartureDate("01.05.2025")
                .chooseBusinessTripReturnDate("31.05.2025")
                .checkDepartmentField()
                .checkHostOrganizationField()
                .checkTicketsOrderChosen()
                .checkDepartureCity("Казань")
                .checkArrivalCity("Ярославль")
                .checkDepartureDate("01.05.2025")
                .checkReturnDate("31.05.2025")
                .clickSaveAndCloseButton()
                .checkValidationErrorMessage("Список командируемых сотрудников не может быть пустым");
    }
}