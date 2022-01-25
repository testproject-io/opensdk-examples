import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.drivers.ActionRunner;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.drivers.ios.IOSDriver;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@EnabledIfEnvironmentVariable(named = "TP_DEV_TOKEN", matches = ".*?")
@DisplayName("Type Random Phone Action")
public class TypeRandomPhoneActionTest {
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
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AUT_PACKAGE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AUT_ACTIVITY);

        driver = new AndroidDriver<>(capabilities, "Examples");
    }

    @Test
    @DisplayName("Example Test")
    void basicTest() {

        // Create Action
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();

        // Set action parameters
        action.countryCode = "1";
        action.maxDigits = 8;

        // Run action
        driver.addons().run(action, By.id("phone"));
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

