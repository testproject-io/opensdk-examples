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


import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Runs tests on {@link ChromeDriver}.
 */
public class TestNG {

    /**
     * Driver instance.
     */
    private static ChromeDriver driver;

    @BeforeClass
    static void setup() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        driver = new ChromeDriver(new ChromeOptions(), "Examples", "TestNG Example");
    }

    @Test(testName = "TestNG Example Test")
    void testExample1() {
        driver.navigate().to("http://example.testproject.io");
        driver.findElement(By.cssSelector("#name")).sendKeys("John Smith");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
        driver.report().step("Login Information provided", true);
        driver.findElement(By.cssSelector("#login")).click();
        driver.report().step("Logged in successfully", driver.findElement(By.cssSelector("#logout")).isDisplayed());
    }

    @AfterClass
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
