import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    private WebDriver driver;


    @Given("I have written my email {string}")
    public void iHaveWrittenMyEmail(String email) {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://login.mailchimp.com/signup/");

        sendKeys(driver, By.id("email"), email);


    }

    @Given("I have written my username {string}")
    public void iHaveWrittenMyUsername(String username) {


        sendKeys(driver, By.id("new_username"), username);


    }

    @Given("I have written my password {string}")
    public void iHaveWrittenMyPassword(String password) {


        sendKeys(driver, By.id("new_password"), password);

    }

    @When("I click the signup button")
    public void iClickTheSignupButton() {

        scroll(driver);

        click(driver, By.id("create-account"));

    }

    @Then("Another page is displayed,with a textmessage")
    public void anotherPageIsDisplayed() {


        String expected = "Check your email";


        String actual = getText(driver, By.xpath("//*[@id=\"signup-content\"]/div/div/div/h1"));


        assertEquals(expected, actual);


driver.quit();

    }

    @Given("I have written an existing username {string}")
    public void iHaveWrittenAnExistingUsername(String username) {


        sendKeys(driver, By.id("new_username"), username);

    }


    @Then("it cannot create an account")
    public void itCannotCreateAnAccount() {


        String expected = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";


        String actual = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div[2]/div/span"));


        assertEquals(expected, actual);

        driver.quit();
    }


    private String getText(WebDriver driver, By by) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        String text = element.getText();
        return text;


    }

    private static void sendKeys(WebDriver driver, By by, String text) {


        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));

        element.sendKeys(text);


    }


    public static void click(WebDriver driver, By by) {

        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));

        driver.findElement(by).click();


    }


    private static void scroll(WebDriver driver) {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

    }

    @Given("I have written my username ,at lest {int}chars {string}")
    public void iHaveWrittenMyUsernameAtLestChars(int arg0, String arg1) {

        sendKeys(driver, By.id("new_username"), "yyyyyyyyyyaaaaaaaaaasssssssssseeeeeeeeeerrrrrrrrrryyyyyyyyyyaaaaaaaaaasssssssssseeeeeeeeeerrrrrrrrrryyyyyyyyyyaaaaaaaaaasssssssssseeeeeeeeeerrrrrrrrrr");


    }

    @Then("It cannot Create account, to many chars")
    public void itCannotCreateAccountToManyChars() {

        String expected = "Enter a value less than 100 characters long";


        String actual = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div[2]/div/span"));


        assertEquals(expected, actual);

        driver.quit();
    }


    @Given("I have write my username {string}")
    public void iHaveWriteMyUsername(String username) {


        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://login.mailchimp.com/signup/");

        sendKeys(driver, By.id("new_username"), username);

    }

    @Given("I have write my password {string}")
    public void iHaveWriteMyPassword(String password) {

        sendKeys(driver, By.id("new_password"), password);

    }


    @When("I click on the signup button")
    public void iClickOnTheSignupButton() {

        scroll(driver);

        click(driver, By.id("create-account"));

    }


    @Then("It cannot create an account,mail missing")
    public void itCannotCreateAnAccountMailMissing() {


        String expected = "Please enter a value";


        String actual = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div[1]/div/span"));


        assertEquals(expected, actual);

        driver.quit();

    }
}