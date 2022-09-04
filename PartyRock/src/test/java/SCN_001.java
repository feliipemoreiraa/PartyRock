import ObjectMap.PageObject;
import ObjectMap.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SCN_001 {

    private static WebDriver webDriver = new ChromeDriver();

    PageObject pageObject = new PageObject(webDriver);

    @Before
    public void inicialize(){
        System.setProperty("webdriver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
        webDriver.manage().window().maximize();
        webDriver.get(Util.BASE_URL);
        webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }
    @Test
    public void submitForms(){
       pageObject.favoritePlayer_textBox.click();
       pageObject.favoritePlayer_textBox.sendKeys("Neymar");

       pageObject.foundedDate_deteField.click();
       pageObject.foundedDate_deteField.sendKeys("11102002");

       pageObject.testingArea_textBox.click();
       pageObject.testingArea_textBox.sendKeys("When I was in my first technology course, I asked my professor which area he thought I would relate to the most, and he said the test area because I was very inquisitive and got along well. so when I met and really identified myself a lot");

       pageObject.submitButton.click();

        String successfullyMessage = pageObject.successfullyValidation.getText();
        if(successfullyMessage.equals("Your information was successfully received. Thank you for filling out the form.")){
            System.out.println("The form is completed successfully");
        }else{
            System.out.println("The form was not completed");
        }
    }
    @After
    public void returnHomePage(){
        webDriver.quit();
    }
}
