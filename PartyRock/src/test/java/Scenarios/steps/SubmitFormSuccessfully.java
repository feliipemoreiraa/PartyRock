package Scenarios.steps;

import ObjectMap.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitFormSuccessfully {

    WebDriver driver = new ChromeDriver();
    PageObject pageObject = new PageObject(driver);
    @Given("Access Form")
    public void accessForm() {
        if(pageObject.favoritePlayer_textBox.isDisplayed()){
            System.out.println("The form was open");
        }else{
            System.out.println("The form was NOT open");
        }

    }

    @And("Input {string}, {string} and {string} Value")
    public void inputAndValue(String arg0, String arg1, String arg2) {
        pageObject.favoritePlayer_textBox.click();
        pageObject.favoritePlayer_textBox.sendKeys("Neymar");

        pageObject.foundedDate_deteField.click();
        pageObject.foundedDate_deteField.sendKeys("11102002");

        pageObject.testingArea_textBox.click();
        pageObject.testingArea_textBox.sendKeys("When I was in my first technology course, I asked my professor which area he thought I would relate to the most, and he said the test area because I was very inquisitive and got along well. so when I met and really identified myself a lot");
    }

    @When("Click submit button")
    public void clickSubmitButton() {
        pageObject.submitButton.click();
    }

    @Then("Successfully tab appears")
    public void successfullyTabAppears() {
        String successfullyMessage = pageObject.successfullyValidation.getText();
        if(successfullyMessage.equals("Your information was successfully received. Thank you for filling out the form.")){
            System.out.println("The form is completed successfully");
        }else{
            System.out.println("The form was not completed");
        }
    }
}
