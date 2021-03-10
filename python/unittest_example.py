# Copyright 2021 TestProject (https://testproject.io)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import unittest

from src.testproject.sdk.drivers import webdriver
from selenium.webdriver import ChromeOptions
from selenium.webdriver.common.by import By


class ExampleUnitTest(unittest.TestCase):

    def setUp(self) -> None:
        self.driver = webdriver.Chrome(chrome_options=ChromeOptions(), project_name="Examples",
                                       job_name="UnitTest Example")

    def tearDown(self) -> None:
        self.driver.quit()

    def test_unittest_example(self):
        self.driver.get("https://example.testproject.io/web/")
        self.driver.find_element(By.CSS_SELECTOR, "#name").send_keys("John Smith")
        self.driver.find_element(By.CSS_SELECTOR, "#password").send_keys("12345")
        self.driver.report().step(description="Login Information provided", message="Step Message", passed=True,
                                  screenshot=True)
        self.driver.find_element(By.CSS_SELECTOR, "#login").click()
        self.driver.report().step(description="Logged in successfully", message="Step Message",
                                  passed=self.driver.find_element(By.CSS_SELECTOR, "#logout").is_displayed())
