package ModernTester.Tests;

import ModernTester.Pages.FormPage;
import ModernTester.TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("FormWithPOM")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AutomationPracticeFormPOMTest extends TestBase {

    FormPage formPage = new FormPage(getDriver());

    @ParameterizedTest
    @Order(1)
    @DisplayName("Navigate to seleniumui.moderntester.pl")
    @ValueSource(strings = "Automation Pratice")
    public void shouldNavigateToPage(String title) {
        getDriver().get("https://seleniumui.moderntester.pl/form.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("Enters first name into firstName input")
    @ValueSource(strings = "John")
    public void shouldFillInFirstName(String firstName) {
        formPage.setFirstNameInput(firstName);
        assertThat(formPage.getFirstNameInput().getAttribute("value"), is(firstName));
    }

    @ParameterizedTest
    @Order(3)
    @DisplayName("Enters last name into lastName input")
    @ValueSource(strings = "Mayer")
    public void shouldFillInLastName(String lastName) {
        formPage.setLastNameInput(lastName);
        assertThat(formPage.getLastNameInput().getAttribute("value"), is(lastName));
    }

    @ParameterizedTest
    @Order(4)
    @DisplayName("Enters email in email input")
    @ValueSource(strings = "John@Mayer.pl")
    public void shouldFillInEmail(String email) {
        formPage.setEmailInput(email);
        assertThat(formPage.getEmailInput().getAttribute("value"), is(email));
    }

    @ParameterizedTest
    @Order(5)
    @DisplayName("CLicks 'male' radio button")
    @ValueSource(ints = 0)
    public void shouldClickRadioButton(int sexRadioIndex) {
        formPage.setSexRadios(sexRadioIndex);
        assertThat(formPage.getSexRadios().get(sexRadioIndex).isSelected(), is(true));
    }
    @ParameterizedTest
    @Order(6)
    @DisplayName("Enters age in age input")
    @ValueSource(strings = "23")
    public void shouldFillInAge(String age) {
        formPage.setAgeInput(age);
        assertThat(formPage.getAgeInput().getAttribute("value"), is(age));
    }

    @Test
    @Order(7)
    @DisplayName("Clicks random 'year of experience' radio button")
    public void shouldClicksRandomYearOfExperienceRadioButton() {
        formPage.setExperienceRadios();
        boolean radioSelected = false;
        for (int i = 0; i < formPage.getExperienceRadios().size(); i++){
            if (formPage.getExperienceRadios().get(i).isSelected()){
                 radioSelected = true;
            }
        }
        assertThat(radioSelected, is(true));
    }

    @ParameterizedTest
    @Order(8)
    @DisplayName("Checks profession checkbox")
    @ValueSource(ints = 1)
    public void shouldCheckProfessionCheckBox(int profesionChbxIndex) {
        formPage.setProfessionCheckboxes(profesionChbxIndex);
        assertThat(formPage.getProfessionCheckboxes().get(profesionChbxIndex).isSelected(), is(true));
    }

    @ParameterizedTest
    @Order(9)
    @DisplayName("Selects continent from select")
    @ValueSource(strings = "europe")
    public void shouldSelectContinent(String continent) {
        formPage.setContinentsSelect(continent);
        assertThat(formPage.getContinentsSelect().getAttribute("value"), is(continent));
    }

    @ParameterizedTest
    @Order(10)
    @DisplayName("Selects command from select")
    @ValueSource(strings = "switch-commands")
    public void shouldSelectCommand(String command) {
        formPage.setCommandsSelect(command);
        assertThat(formPage.getCommandsSelect().getAttribute("value"), is(command));
    }

    @ParameterizedTest
    @Order(11)
    @DisplayName("Attaches file from resources")
    @ValueSource(strings = "\\src\\main\\resources\\Files\\File.txt")
    public void shouldAttachFile(String contentPath) {
        String filePath = System.getProperty("user.dir") + contentPath;
        formPage.setFileInput(filePath);
        assertThat(formPage.getFileInput().getAttribute("value"), containsString("File.txt"));
    }

    @Test
    @Order(12)
    @DisplayName("Clicks 'Sign in' button")
    public void shouldClickSignInButton() {
        formPage.setSignInButton();
    }

    @ParameterizedTest
    @Order(13)
    @DisplayName("Checks message")
    @ValueSource(strings = "Form send with success")
    public void shouldConfirmSuccessMessage(String message) {
        assertThat(formPage.getSuccessMessage().getText(), is(message));
    }
}
