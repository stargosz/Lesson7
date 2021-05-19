package AutomationPractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//li[1]/div/div[2]/div[1]/span)[1]")
    WebElement price1;

    @FindBy (xpath = "(//li[2]/div/div[2]/div[1]/span)[1]")
    WebElement price2;

    @FindBy (xpath = "(//li[3]/div/div[2]/div[1]/span)[1]")
    WebElement price3;

    @FindBy (xpath = "(//li[4]/div/div[2]/div[1]/span)[1]")
    WebElement price4;

    @FindBy (xpath = "(//li[5]/div/div[2]/div[1]/span)[1]")
    WebElement price5;

    @FindBy (xpath = "(//li[6]/div/div[2]/div[1]/span)[1]")
    WebElement price6;

    @FindBy (xpath = "(//li[7]/div/div[2]/div[1]/span)[1]")
    WebElement price7;

    @FindBy(css = "#homefeatured .right-block .price")
    List<WebElement> allPricesElements;

    @Override
    public String toString() {
        return "HomePage{" +
                "allPricesElements=" + allPricesElements +
                '}';
    }

    public List<WebElement> getAllPricesElements() {
        return allPricesElements;
    }

    public WebElement getPrice1() {
        return price1;
    }

    public WebElement getPrice2() {
        return price2;
    }

    public WebElement getPrice3() {
        return price3;
    }

    public WebElement getPrice4() {
        return price4;
    }

    public WebElement getPrice5() {
        return price5;
    }

    public WebElement getPrice6() {
        return price6;
    }

    public WebElement getPrice7() {
        return price7;
    }
}
