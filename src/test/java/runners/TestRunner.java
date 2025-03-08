package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files
        glue = {"stepDefinitions"}, // Path to step definition files
        plugin = {
                "pretty", // For readable console output
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber-reports/Cucumber.json", // JSON report
                "junit:target/cucumber-reports/Cucumber.xml" // JUnit report
        },
        monochrome = true // Makes console output more readable
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
