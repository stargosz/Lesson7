package AutomationPractice.Tests;

import AutomationPractice.Pages.HomePage;
import ModernTester.TestBase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FindSiglePriceElements extends TestBase {

    HomePage homePage = new HomePage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'automationPractice' web page")
    @Order(1)
    @ValueSource(strings = "My Store")
    public void shouldOpenWebPage(String title) {
        getDriver().get("http://automationpractice.com/index.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }


    @ParameterizedTest
    @DisplayName("Read price of Faded Short Sleeve T-shirts")
    @Order(2)
    @ValueSource(strings = "$16.51")
    public void shouldFindPrice1Element(String actualPrice) {
        homePage.getPrice1();
        assertThat(homePage.getPrice1().getText(), is(actualPrice));
    }

    @ParameterizedTest
    @DisplayName("Read price of Blouse")
    @Order(3)
    @ValueSource(strings = "$27.00")
    public void shouldFindPrice2Element(String actualPrice) {
        homePage.getPrice2();
        assertThat(homePage.getPrice2().getText(), is(actualPrice));
    }

    @ParameterizedTest
    @DisplayName("Read price of Printed Dress")
    @Order(4)
    @ValueSource(strings = "$26.00")
    public void shouldFindPrice3Element(String actualPrice) {
        homePage.getPrice3();
        assertThat(homePage.getPrice3().getText(), is(actualPrice));
    }

    @ParameterizedTest
    @DisplayName("Read price of Printed Dress")
    @Order(5)
    @ValueSource(strings = "$50.99")
    public void shouldFindPrice4Element(String actualPrice) {
        homePage.getPrice4();
        assertThat(homePage.getPrice4().getText(), is(actualPrice));
    }


    @ParameterizedTest
    @DisplayName("Read price of Printed Summer Dress")
    @Order(2)
    @ValueSource(strings = "$28.98")
    public void shouldFindPrice5Element(String actualPrice) {
        homePage.getPrice5();
        assertThat(homePage.getPrice5().getText(), is(actualPrice));
    }

    @ParameterizedTest
    @DisplayName("Read price of Printed Summer Dress")
    @Order(2)
    @ValueSource(strings = "$30.50")
    public void shouldFindPrice6Element(String actualPrice) {
        homePage.getPrice6();
        assertThat(homePage.getPrice6().getText(), is(actualPrice));
    }

    @ParameterizedTest
    @DisplayName("Read price of Printed Chiffon Dress")
    @Order(2)
    @ValueSource(strings = "$16.40")
    public void shouldFindPrice7Element(String actualPrice) {
        homePage.getPrice7();
        assertThat(homePage.getPrice7().getText(), is(actualPrice));
    }

}
