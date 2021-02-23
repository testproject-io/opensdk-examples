// <copyright file="MSTestExample.cs" company="TestProject">
// Copyright 2020 TestProject (https://testproject.io)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// </copyright>

using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using ChromeDriver = TestProject.OpenSDK.Drivers.Web.ChromeDriver;

namespace TestProject.OpenSDK.Examples
{
    /// <summary>
    /// MSTest example.
    /// </summary>
    [TestClass]
    public class MSTestExample
    {
        private ChromeDriver driver;

        /// <summary>
        /// Setup method.
        /// </summary>
        [TestInitialize]
        public void Setup()
        {
            this.driver = new ChromeDriver(chromeOptions: new ChromeOptions(), projectName: "My First C# Project", jobName: "My First C# Job");
        }

        /// <summary>
        /// The test method.
        /// </summary>
        [TestMethod("My First MSTest Test")]
        public void MyFirstTest()
        {
            this.driver.Navigate().GoToUrl("http://example.testproject.io");
            this.driver.FindElement(By.CssSelector("#name")).SendKeys("John Smith");
            this.driver.FindElement(By.CssSelector("#password")).SendKeys("12345");
            this.driver.Report().Step("Login Information provided", screenshot: true);
            this.driver.FindElement(By.CssSelector("#login")).Click();
            this.driver.Report().Step("Logged in successfully", passed: this.driver.FindElement(By.CssSelector("#logout")).Displayed);
        }

        /// <summary>
        /// Cleanup method.
        /// </summary>
        [TestCleanup]
        public void TearDown()
        {
            this.driver.Quit();
        }
    }
}
