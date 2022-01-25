/*
 * Copyright (c) 2021 TestProject LTD. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example of using a web action defined for multiple browsers.
 */
@EnabledIfEnvironmentVariable(named = "TP_DEV_TOKEN", matches = ".*?")
@DisplayName("Clear Fields Action Test")
public class ClearFieldsActionTest {

    @Test
    public void chromeTest()
            throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        ChromeDriver driver = new ChromeDriver(new ChromeOptions(), "Examples");
        runAction(driver);
    }

    @Test
    public void firefoxTest() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        FirefoxDriver driver = new FirefoxDriver(new FirefoxOptions(), "Examples");
        runAction(driver);
    }

    @Test
    public void edgeTest() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        EdgeDriver driver = new EdgeDriver(new EdgeOptions(), "Examples");
        runAction(driver);
    }

    @Test
    public void explorerTest() throws InvalidTokenException, ObsoleteVersionException, AgentConnectException, IOException {
        InternetExplorerDriver driver = new InternetExplorerDriver(new InternetExplorerOptions(), "Examples");
        runAction(driver);
    }

    @Test
    public void AndroidDriverChromeTest() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        AndroidDriver<WebElement> driver;

        String DUT_UDID ="YOUR_TP_ANDROID_DUT_UDID";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.UDID, DUT_UDID);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        driver = new AndroidDriver<>(capabilities, "Examples");
        runAction(driver);
    }

    @Test
    public void iOSSafariDriverTest() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {
        IOSDriver<WebElement> driver;
        String DUT_UDID = "YOUR_TP_IOS_DUT_UDID";
        String DUT_NAME = "YOUR_TP_IOS_DUT_NAME";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.UDID, DUT_UDID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DUT_NAME);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);

        driver = new IOSDriver<>(capabilities, "Examples");
        runAction(driver);
    }

    private <D extends RemoteWebDriver> void runAction(final ActionRunner<D> runner) {
        ClearFieldsAction action = new ClearFieldsAction();
        runner.addons().run(action);
        runner.report();
    }
}
