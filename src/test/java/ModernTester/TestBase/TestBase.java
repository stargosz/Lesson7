package ModernTester.TestBase;

import ModernTester.Setup.Screenshot;
import ModernTester.Setup.Timestamp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestBase {


    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    void beforeEach() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void afterEach() throws IOException {
        Screenshot.takeScreenShot(driver, "src/main/resources/Screenshots/" + Timestamp.timestamp() + ".png");
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}