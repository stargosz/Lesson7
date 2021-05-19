package ModernTester.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class FormPage {

    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Random rnd = new Random();

    @FindBy(css = "#inputFirstName3")
    WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    WebElement emailInput;

    @FindBy(css = "[name='gridRadiosSex']")
    List<WebElement> sexRadios;

    @FindBy(css = "#inputAge3")
    WebElement ageInput;

    @FindBy(css = "[name='gridRadiosExperience']")
    List<WebElement> experienceRadios;

    @FindBy(css = "[name='gridCheckboxProfession']")
    List<WebElement> professionCheckboxes;

    @FindBy(css = "#selectContinents")
    WebElement continentsSelect;

    @FindBy(css = "#selectSeleniumCommands")
    WebElement commandsSelect;

    @FindBy(css = "#chooseFile")
    WebElement fileInput;

    @FindBy(css = ".btn-primary")
    WebElement signInButton;

    @FindBy(css = "#validator-message")
    WebElement successMessage;

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public List<WebElement> getSexRadios() {
        return sexRadios;
    }

    public List<WebElement> getExperienceRadios() {
        return experienceRadios;
    }

    public List<WebElement> getProfessionCheckboxes() {
        return professionCheckboxes;
    }

    public WebElement getAgeInput() {
        return ageInput;
    }


    public WebElement getContinentsSelect() {
        return continentsSelect;
    }

    public WebElement getCommandsSelect() {
        return commandsSelect;
    }

    public WebElement getFileInput() {
        return fileInput;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public void setFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void setSexRadios(int radioIndex) {
        sexRadios.get(radioIndex).click();
    }

    public void setAgeInput(String age) {
        ageInput.sendKeys(age);
    }

    public void setExperienceRadios() {
        int index = rnd.nextInt(experienceRadios.size());
        if (!experienceRadios.get(index).isSelected()) {
            experienceRadios.get(index).click();
        }

    }

    public void setProfessionCheckboxes(int professionIndex) {
        professionCheckboxes.get(professionIndex).click();
    }

    public void setContinentsSelect(String continent) {
        Select continents = new Select(continentsSelect);
        continents.selectByValue(continent);
    }

    public void setCommandsSelect(String command) {
        Select commands = new Select(commandsSelect);
        commands.selectByValue(command);
    }

    public void setFileInput(String filePath) {
        fileInput.sendKeys(filePath);
    }

    public void setSignInButton() {
        signInButton.click();
    }

    public void setSuccessMessage(WebElement successMessage) {
        this.successMessage = successMessage;
    }

}