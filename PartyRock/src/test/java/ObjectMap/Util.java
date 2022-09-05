package ObjectMap;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Util {
        public static final String BASE_URL = "https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=en_US&p_p_auth=QERTpm2b";
        public static final  String CHROME_DRIVER_LOCATION = "chromedriver";

        @Before
        public void initialize(){
                System.setProperty("driver.chrome.driver", Util.CHROME_DRIVER_LOCATION);
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
        }
}
