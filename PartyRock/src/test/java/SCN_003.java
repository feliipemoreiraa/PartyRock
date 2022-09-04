import ObjectMap.PageObject;
import ObjectMap.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SCN_003 {

    private static WebDriver webDriver = new ChromeDriver();

    PageObject pageObject = new PageObject(webDriver);

    @Before
    public void submitForm(){
        System.setProperty("webdriver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
        webDriver.manage().window().maximize();
        webDriver.get(Util.BASE_URL);
        webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }
    @Test
    public void validateSubmitAgainButton(){
        pageObject.favoritePlayer_textBox.click();
        pageObject.favoritePlayer_textBox.sendKeys("Felipe");

        pageObject.foundedDate_deteField.click();
        pageObject.foundedDate_deteField.sendKeys("02021999");

        pageObject.testingArea_textBox.click();
        pageObject.testingArea_textBox.sendKeys("Test ");

        pageObject.submitButton.click();

        String successfullyMessage;
        successfullyMessage = pageObject.successfullyValidation.getText();
        if(successfullyMessage.equals("Your information was successfully received. Thank you for filling out the form.")){
            System.out.println("The form is completed successfully");
        }else{
            System.out.println("The form was not completed");
        }

        pageObject.submitAgain_Button.click();

    }
    @After
    public void returnHomePage(){
        webDriver.quit();
    }
}
