import io.testproject.sdk.drivers.GenericDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.testng.Assert;

import java.io.IOException;


@EnabledIfEnvironmentVariable(named = "TP_DEV_TOKEN", matches = ".*?")
@DisplayName("Addition Action Test")
public class AdditionActionTest {

    /**
     * Driver instance.
     */
    private static GenericDriver driver;

    @BeforeAll
    static void setup() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new GenericDriver("Examples");
    }

    @Test
    @DisplayName("Example Test")
    void testExample() {
        AdditionAction action = new AdditionAction();
        action.a = 2;
        action.b = 3;
        driver.addons().run(action);
        Assert.assertEquals(5, action.result);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}