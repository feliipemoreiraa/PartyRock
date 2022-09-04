package ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@class='form-control ddm-field-text']")
    public WebElement favoritePlayer_textBox;

    @FindBy(xpath = "//input[@class='form-control input-group-inset input-group-inset-after']")
    public WebElement foundedDate_deteField;

    @FindBy(xpath = "//textarea[@class='ddm-field-text form-control']")
    public WebElement testingArea_textBox;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='lfr-ddm__default-page-container']/p[text()='Your information was successfully received. Thank you for filling out the form.']")
    public WebElement successfullyValidation;

    @FindBy(xpath = "//label[text()='What is your favorite soccer player?']/following-sibling::span/div[text()='This field is required.']")
    public WebElement requiredFieldText_SoccerPlayer;

    @FindBy(xpath = "//label[text()='what was the date that Liferay was founded?']/following-sibling::span/div[text()='This field is required.']")
    public WebElement requiredFieldText_DateField;

    @FindBy(xpath = "//label[text()='Why did you join the testing area?']/following-sibling::span/div[text()='This field is required.']")
    public WebElement requiredFieldText_testingArea;

    @FindBy(xpath = "//button[text()='Submit Again']")
    public WebElement submitAgain_Button;
}
