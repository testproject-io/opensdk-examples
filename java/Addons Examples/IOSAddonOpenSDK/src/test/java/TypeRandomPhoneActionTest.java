import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.drivers.ios.IOSDriver;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@DisplayName("Clear Fields Action Test")
public class TypeRandomPhoneActionTest {
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
    public void runElementAction() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.UDID, DUT_UDID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DUT_NAME);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, AUT_BUNDLE_ID);

        driver = new IOSDriver<>(capabilities, "Examples");

        // Create Action
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();

        // Set action parameters
        action.countryCode = "1";
        action.maxDigits = 8;

        // Run action
        driver.addons().run(action, By.id("phone"));
    }
}
