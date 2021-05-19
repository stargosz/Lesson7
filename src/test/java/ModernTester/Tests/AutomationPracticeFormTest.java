package ModernTester.Tests;

import ModernTester.TestBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AutomationPracticeFormTest extends TestBase {

    Random rnd = new Random();

    String url;
    String firstName;
    String lastName;
    String email;
    String filePath;
    String age;
    String continent;
    String message;

    @Test
    public void shouldFillFormWithSuccess() {
        url = "https://seleniumui.moderntester.pl/form.php";
        getDriver().get(url);
        firstName = "John";
        getDriver().findElement(By.cssSelector("#inputFirstName3")).sendKeys(firstName);
        lastName = "Mayer";
        getDriver().findElement(By.cssSelector("#inputLastName3")).sendKeys(lastName);
        email = "JohnMarye@gmail.com";
        getDriver().findElement(By.cssSelector("#inputEmail3")).sendKeys(email);
        getDriver().findElements(By.cssSelector("[name='gridRadiosSex']")).get(0).click();
        age = "13";
        getDriver().findElement(By.cssSelector("#inputAge3")).sendKeys(age);
        List<WebElement> gridRadiosExperience = getDriver().findElements(By.cssSelector("[name='gridRadiosExperience']"));
        int index = rnd.nextInt(gridRadiosExperience.size());
        if (!gridRadiosExperience.get(index).isSelected()) {
            gridRadiosExperience.get(index).click();
        }
        getDriver().findElements(By.cssSelector("[name='gridCheckboxProfession")).get(1).click();
        continent = "north-america";
        Select continents = new Select(getDriver().findElement(By.cssSelector("#selectContinents")));
        Select seleniumCommands = new Select(getDriver().findElement(By.cssSelector("#selectSeleniumCommands")));
        seleniumCommands.selectByIndex(3);
        System.out.println(seleniumCommands.getOptions());
        filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\File.txt";
        getDriver().findElement(By.cssSelector("#chooseFile")).sendKeys(filePath);
        getDriver().findElement(By.cssSelector(".btn-primary")).click();
        WebElement msg = getDriver().findElement(By.cssSelector("#validator-message"));
        message = "Form send with success";
        assertThat(msg.getText(), is(message));
    }
}