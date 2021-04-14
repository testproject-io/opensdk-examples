// Copyright 2021 TestProject (https://testproject.io)
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import { ThenableBaseDriver, Builder } from '@tpio/javascript-opensdk';
import { By } from 'selenium-webdriver';

import chai, { assert, expect } from 'chai';
import chaiAsPromised from 'chai-as-promised';

import LoginPage from './pageobjects/loginPage';
import ProfilePage from './pageobjects/profilePage';

// Chai Promise extensions
chai.use(chaiAsPromised);

describe('Successful and Failed Tests', () => {
  let driver: ThenableBaseDriver;

  beforeEach(() => {
    driver = new Builder().forBrowser('chrome').withToken('MY_DEV_TOKEN').build();
  });

  afterEach(async () => {
    await driver.quit();
  });

  it('Login and check if greeting displayed', async () => {
    const login = new LoginPage(driver);
    await login.OpenUrl();
    await login.LoginAs('John Smith', '12345');

    assert.equal(await new ProfilePage(driver).GreetingsAreDisplayed(), true);
  });

  it('Fail looking for #does_not_exist', async () => {
    const login = new LoginPage(driver);
    await login.OpenUrl();
    await login.LoginAs('John Smith', '12345');

    assert.equal(await new ProfilePage(driver).GreetingsAreDisplayed(), true);

    // Reduce driver timeout
    await driver.manage().timeouts().implicitlyWait(0);
    await expect(driver.findElement(By.css('#does_not_exist'))).to.eventually.be.rejected;
  });
});
