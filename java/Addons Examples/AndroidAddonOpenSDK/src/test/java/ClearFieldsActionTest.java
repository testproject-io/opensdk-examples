import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example of using a web action defined for multiple browsers.
 */
@EnabledIfEnvironmentVariable(named = "TP_DEV_TOKEN", matches = ".*?")
@DisplayName("Clear Fields Action")
public class ClearFieldsActionTest {
    /**
     * Timeout.
     */
    private static final int TIMEOUT = 5;
    /**
     * Driver instance.
     */
    private static AndroidDriver<MobileElement> driver;
    /**
     * UDID (Universally unique identifier) of the device under test (DUT).
     */
    private static final String DUT_UDID = "YOUR_TP_ANDROID_DUT_UDID";
    /**
     * Android Package name of the application under test (AUT).
     */
    private static final String AUT_PACKAGE_NAME = "YOUR_TP_ANDROID_AUT_PACKAGE";
    /**
     * Android Activity name to start with, in the application under test (AUT).
     */
    private static final String AUT_ACTIVITY = "YOUR_TP_ANDROID_AUT_ACTIVITY";

    @BeforeAll
    private static void setup()
            throws InvalidTokenException, AgentConnectException, MalformedURLException, ObsoleteVersionException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.UDID, DUT_UDID);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AUT_PACKAGE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AUT_ACTIVITY);

        driver = new AndroidDriver<>(capabilities, "Examples");
    }

    @Test
    public void androidTest()
            throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        // Reset App
        driver.resetApp();

        // Login using provided credentials
        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");
        ClearFieldsAction action = new ClearFieldsAction();
        driver.addons().run(action);
    }
}
