package Scenarios.steps;

import ObjectMap.PageObject;
import ObjectMap.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SubmitForm {
    private static WebDriver driver = new ChromeDriver();
    PageObject pageObject = new PageObject(driver);
    
    @Before
    public void inicialize(){
        System.setProperty("driver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
    }
    @Given("Access URL form")
    public void accessURLForm() {
        driver.get(Util.BASE_URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
    @And("Input {string}, {string} and {string} Values")
    public void inputAndValues(String playerName,String dateValue, String testingArea ) throws InterruptedException {
        Thread.sleep(15000);
        pageObject.favoritePlayer_textBox.click();
        pageObject.favoritePlayer_textBox.sendKeys("Felipe");
        pageObject.foundedDate_deteField.click();
        pageObject.foundedDate_deteField.sendKeys("02021999");

        pageObject.testingArea_textBox.click();
        pageObject.testingArea_textBox.sendKeys("Test");
    }
    @When("Click Submit Button")
    public void clickSubmitButton() {
        pageObject.submitButton.click();
    }
    @Then("Successfully Tab Appears")
    public void successfullyTabAppears() {
        String successfullyMessage = pageObject.successfullyValidation.getText();
        if(successfullyMessage.equals("Your information was successfully received. Thank you for filling out the form.")){
            System.out.println("The form is completed successfully");
        }else{
            System.out.println("The form was not completed");
        }
    }
}
