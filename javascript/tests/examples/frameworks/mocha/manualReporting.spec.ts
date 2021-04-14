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
import { assert } from 'chai';

import LoginPage from './pageobjects/loginPage';
import ProfilePage from './pageobjects/profilePage';

describe('Test is reported as passed and failed with additional step', () => {
  let driver: ThenableBaseDriver;

  beforeEach(() => {
    driver = new Builder().forBrowser('chrome').withToken('MY_DEV_TOKEN').build();
    driver.report().disableAutoTestReports(true);
  });

  afterEach(async () => {
    await driver.quit();
  });

  it('Should report as passed', async () => {
    const login = new LoginPage(driver);
    await login.OpenUrl();
    await login.LoginAs('John Smith', '12345');

    assert.equal(await new ProfilePage(driver).GreetingsAreDisplayed(), true);
    driver.report().test('Passing test', true);
  });

  it('Should report as failed', async () => {
    const login = new LoginPage(driver);
    await login.OpenUrl();
    await login.LoginAs('John Smith', '12345');

    assert.equal(await new ProfilePage(driver).GreetingsAreDisplayed(), true);
    await driver
      .report()
      .step('Failing step with screenshot', 'An additional message that goes with the step', true, true);

    driver.report().test('Failing test', false);
  });
});
