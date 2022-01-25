import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.drivers.ios.IOSDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;


@DisplayName("Clear Fields Action Test")
public class ClearFieldsActionTest {


    /**
     * Driver instance.
     */
    private IOSDriver<MobileElement> driver;

    /**
     * UDID (Universally unique identifier) of the device under test (DUT).
     */
    private static final String DUT_UDID = "YOUR_TP_IOS_DUT_UDID";

    /**
     * Name of the device under test (DUT).
     */
    private static final String DUT_NAME = "YOUR_TP_IOS_DUT_NAME";

    /**
     * iOS BundleID name of the application under test (AUT).
     */
    private static final String AUT_BUNDLE_ID = "YOUR_TP_IOS_AUT_BUNDLE_ID";


    @Test
    public void runAction() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.UDID, DUT_UDID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DUT_NAME);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, AUT_BUNDLE_ID);

        driver = new IOSDriver<>(capabilities, "Examples");

        // Create Action
        ClearFieldsAction action = new ClearFieldsAction();

        // Prepare state
        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");

        // Run action
        driver.addons().run(action);
    }
}
