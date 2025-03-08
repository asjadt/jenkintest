package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.Assert.assertEquals;

public class UIStepDefinitions {
    WebDriver driver;

    @Given("I open the browser and navigate to {string}")
    public void i_open_the_browser_and_navigate_to(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/atariq/Downloads/chromedriver-mac-x64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.get(url);
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }
}
