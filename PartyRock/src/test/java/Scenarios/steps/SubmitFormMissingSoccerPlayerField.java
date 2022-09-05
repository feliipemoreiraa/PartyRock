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

public class SubmitFormMissingSoccerPlayerField {
    private static  WebDriver driver = new ChromeDriver();
    PageObject pageObject = new PageObject(driver);

    @Before
    public void inicialize(){
        System.setProperty("driver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
        System.out.println("URl Opened");
        driver.manage().window().maximize();
        System.out.println("URl maximized");
    }
    @Given("Access URL form")
    public void accessURLForm() {
        driver.get(Util.BASE_URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
    @And("Imput {string} and {string} values")
    public void imputAndValues(String dateField, String textingArea) throws InterruptedException {
        Thread.sleep(15000);
        pageObject.foundedDate_deteField.click();
        pageObject.foundedDate_deteField.sendKeys("02021999");

        pageObject.testingArea_textBox.click();
        pageObject.testingArea_textBox.sendKeys("Test");
    }
    @When("Click Submit Button")
    public void clickSubmitButton() {
        pageObject.submitButton.click();
    }
    @Then("Soccer Player field show required field Message")
    public void fieldOfSoccerPlayerShowRequiredFieldMessage() {
        if(pageObject.requiredFieldText_SoccerPlayer.isDisplayed()){
            System.out.println("The Required Field message appears on Soccer Player field.");
        }else{
            System.out.println("The Required Field message didn't appears on Soccer Player field.");
        }
    }
}
