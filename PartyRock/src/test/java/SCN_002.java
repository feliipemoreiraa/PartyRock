import ObjectMap.PageObject;
import ObjectMap.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SCN_002 {

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
    public void validateRequiredFieldsMessage() throws InterruptedException {
        Thread.sleep(15000);
        pageObject.submitButton.click();

        Thread.sleep(7000);
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
    @After
    public void returnHomePage(){

        webDriver.quit();
    }
}
