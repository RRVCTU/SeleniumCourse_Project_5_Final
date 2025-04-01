package tests;

import basetestsclass.BaseTests;
import org.junit.Test;

public class FirstTest extends BaseTests {

    @Test
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