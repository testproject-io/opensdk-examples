import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Run a Simple BDD Cucumber test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "io.testproject.sdk.internal.reporting.extensions.cucumber.CucumberReporter")
class CucumberTest {
    // CucumberTestSteps are glued automatically as they are in the same package.
}
