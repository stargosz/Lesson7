package AutomationPractice.Tests;

import AutomationPractice.Pages.HomePage;
import ModernTester.TestBase.TestBase;
import org.apache.commons.compress.utils.Lists;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FindAllPricesElements extends TestBase {
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

    @Test
    @Order(2)
    @DisplayName("Finds all 7 price elements")
    public void shuoldReadAll7PriceElements(){
        assertThat(homePage.getAllPricesElements().size(), is(7));
    }
}
