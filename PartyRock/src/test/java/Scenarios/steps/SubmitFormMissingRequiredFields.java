package Scenarios.steps;

import ObjectMap.PageObject;
import ObjectMap.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SubmitFormMissingRequiredFields {
    private static final WebDriver driver = new ChromeDriver();
    PageObject pageObject = new PageObject(driver);

    @Before
    public void inicialize(){
        System.setProperty("driver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
    }
    @Given("Access  URL form")
    public void accessURLForm() {
        driver.get(Util.BASE_URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
    @When("Do not populate required fields and click submit Button")
    public void clickSubmitButton() {
        pageObject.submitButton.click();
    }
    @Then("All fields show required fields")
    public void allFieldsShowRequiredFields() {
       if(pageObject.requiredFieldText_SoccerPlayer.isDisplayed()){
           System.out.println("The Required Field message appears on Soccer Player field.");
       }else{
           System.out.println("The Required Field message didn't appears on Soccer Player field.");
       }
       if(pageObject.requiredFieldText_DateField.isDisplayed()){
           System.out.println("The Required Field message appears on Date field.");
       }else{
           System.out.println("The Required Field message didn't appears on Date field.");
       }
       if(pageObject.requiredFieldText_testingArea.isDisplayed()){
           System.out.println("The Required Field message appears on the Soccer Player field.");
       }else {
           System.out.println("The Required Field message didn't appears on the Soccer Player field.");
       }
    }
}
