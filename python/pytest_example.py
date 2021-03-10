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

import pytest

from src.testproject.sdk.drivers import webdriver
from selenium.webdriver import ChromeOptions
from selenium.webdriver.common.by import By


@pytest.fixture
def driver():
    """
    Pytest fixture function that manages the test's Setup and Teardown.
    Creates the Chrome WebDriver and quits it once all test cases are done.
    See: https://docs.pytest.org/en/stable/fixture.html for more information on how fixture can be used.
    """
    driver = webdriver.Chrome(chrome_options=ChromeOptions(), project_name="Examples", job_name="Pytest Example")
    yield driver
    driver.quit()


def test_pytest_example(driver):
    """
    A simple login test on TestProject's example webpage.
    :param driver: Is the driver instance used for this test function.
    """
    driver.get("https://example.testproject.io/web/")
    driver.find_element(By.CSS_SELECTOR, "#name").send_keys("John Smith")
    driver.find_element(By.CSS_SELECTOR, "#password").send_keys("12345")
    driver.report().step(description="Login Information provided", message="Step Message", passed=True, screenshot=True)
    driver.find_element(By.CSS_SELECTOR, "#login").click()
    driver.report().step(description="Logged in successfully", message="Step Message",
                         passed=driver.find_element(By.CSS_SELECTOR, "#logout").is_displayed())
