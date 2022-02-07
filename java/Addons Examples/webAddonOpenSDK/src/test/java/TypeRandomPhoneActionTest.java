import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.testproject.sdk.drivers.ActionRunner;
import io.testproject.sdk.drivers.android.AndroidDriver;
import io.testproject.sdk.drivers.ios.IOSDriver;
import io.testproject.sdk.drivers.web.*;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.io.IOException;
import java.net.MalformedURLException;


/**
 * Example of using a web action defined for multiple browsers.
 */
@DisplayName("Type Random Phone Action")
public class TypeRandomPhoneActionTest {

    @Test
    public void chromeTest()
            throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        ChromeDriver driver = new ChromeDriver(new ChromeOptions());
        driver.navigate().to("https://example.testproject.io/web/");
        runAction(driver);
    }

    @Test
    public void firefoxTest() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        FirefoxDriver driver = new FirefoxDriver(new FirefoxOptions(), "Examples");
        driver.navigate().to("https://example.testproject.io/web/");
        runAction(driver);
    }

    @Test
    public void edgeTest() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        EdgeDriver driver = new EdgeDriver(new EdgeOptions(), "Examples");
        driver.navigate().to("https://example.testproject.io/web/");
        runAction(driver);
    }

    @Test
    public void explorerTest() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        InternetExplorerDriver driver = new InternetExplorerDriver(new InternetExplorerOptions(), "Examples");
        driver.navigate().to("https://example.testproject.io/web/");
        runAction(driver);
    }

    @Test
    public void AndroidDriverChromeTest() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {

        String YOUR_DEVICE_UDID = "YOUR_TP_ANDROID_DUT_UDID;

        AndroidDriver<WebElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.UDID, YOUR_DEVICE_UDID);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

        driver = new AndroidDriver<>(capabilities, "Examples");
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();
        driver.addons().run(action, new By.ByXPath("//android.widget.EditText"));
    }

    @Test
    public void iOSSafariDriverTest() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        String DUT_UDID = "YOUR_TP_IOS_DUT_UDID";
        String DUT_NAME = "YOUR_TP_IOS_DUT_NAME";

        IOSDriver<WebElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.UDID, DUT_UDID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DUT_NAME);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);

        driver = new IOSDriver<>(capabilities, "Examples");
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();
        driver.addons().run(action, new By.ByXPath("//android.widget.EditText"));
    }

    private <D extends RemoteWebDriver> void runAction(final ActionRunner<D> runner) {
        TypeRandomPhoneAction action = new TypeRandomPhoneAction();
        runner.addons().run(action, By.id("name"));
    }
}