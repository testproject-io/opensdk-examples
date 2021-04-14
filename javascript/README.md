# Examples for TestProject JavaScript OpenSDK

[TestProject](https://testproject.io) is a **Free** Test Automation platform for Web, Mobile and API testing. \
To get familiar with the TestProject, visit our main [documentation](https://docs.testproject.io/) website.

TestProject SDK is a single, integrated interface to scripting with the most popular open source test automation frameworks.

From now on, you can effortlessly execute Selenium and Appium native tests using a single automation platform that already takes care of all the complex setup, maintenance and configs.

With one unified SDK available across multiple languages, developers and testers receive a go-to toolset, solving some of the greatest challenges in open source test automation.

With TestProject SDK, users save a bunch of time and enjoy the following benefits out of the box:

- 100% open source and available as an [NPM](https://www.npmjs.com/package/@tpio/javascript-opensdk) package.
- 5-minute simple Selenium setup with a single [Agent](https://docs.testproject.io/testproject-agents) deployment.
- Automatic test reports in HTML/PDF format (including screenshots).
- Collaborative reporting dashboards with execution history and RESTful API support.
- Always up-to-date with the latest and stable Selenium driver version.
- A simplified, familiar syntax for both web and mobile applications.
- Complete test runner capabilities for both local and remote executions, anywhere.
- Cross platform support for Mac, Windows, Linux and Docker.
- Ability to store and execute tests locally on any source control tool, such as Git.

# Getting started

To get started, you need to complete the following prerequisites checklist:

- Login to your account at https://app.testproject.io/ or [register](https://app.testproject.io/signup/) a new one.
- [Download](https://app.testproject.io/#/download) and install an Agent for your operating system or pull a container from [Docker Hub](https://hub.docker.com/r/testproject/agent).
- Run the Agent and [register](https://docs.testproject.io/getting-started/installation-and-setup#register-the-agent) it with your Account.
- Get a development token from [Integrations / SDK](https://app.testproject.io/#/integrations/sdk) page.

> You must have Node.js v12 or newer installed.

## Running the tests

Clone this repository, enter the javascript folder and run the following commands to build the tests:

```shell
npm install
npm run build
```

Run the simple example test:

```shell
node dist/drivers/basicChromeTest.spec.js
```

Run the mocha based example tests:

```shell
npm run tests
```
