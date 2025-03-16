package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import java.util.Optional;

@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files
        glue = {"stepDefinitions"}, // Path to step definition files
        plugin = {
                "pretty", // For readable console output
                "html:target/${buildNumber}/cucumber-reports/cucumber-html-reports", // Build-specific HTML report
                "json:target/${buildNumber}/cucumber-reports/Cucumber.json", // Build-specific JSON report
                "junit:target/${buildNumber}/cucumber-reports/Cucumber.xml" // Build-specific JUnit report
        },
        monochrome = true // Makes console output more readable
)
public class TestRunner extends AbstractTestNGCucumberTests {

    static {
        // Retrieve BUILD_NUMBER from environment or set default to "local"
        String buildNumber = Optional.ofNullable(System.getenv("BUILD_NUMBER")).orElse("local");

        // Set buildNumber as a system property for dynamic report paths
        System.setProperty("buildNumber", buildNumber);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
