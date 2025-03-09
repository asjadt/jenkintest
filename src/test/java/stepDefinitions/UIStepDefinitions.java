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

         String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
        // Path for Windows
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
    } else if (os.contains("mac")) {
        // Path for Mac
        System.setProperty("webdriver.chrome.driver", "/Users/username/Downloads/chromedriver-mac-x64/chromedriver");
    } else {
        throw new RuntimeException("Unsupported operating system: " + os);
    }
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
