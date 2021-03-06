package org.oxtrust.qa.steps;

import org.oxtrust.qa.pages.login.HomePage;
import org.oxtrust.qa.pages.passport.PassportPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class PassportConfigurationSteps extends BaseSteps {

	private HomePage homePage = new HomePage();

	private PassportPage passportPage = new PassportPage();
	
	@Before
	public void setup(Scenario scenario) {
		startRecorder(scenario);
	}

	@And("^I go to passport configuration page$")
	public void goToPassportConfigPage() {
		homePage.goToPassportConfigPage();
	}
	
	
	@And("^I set the log level to '(.+)'$")
	public void setLogLevel(String logLevel) {
		passportPage.setLogLevel(logLevel);
	}
	
	@And("^I update the config$")
	public void setUpdate() {
		passportPage.saveConfig();
	}
	
	@After
	public void clear(Scenario scenario) {
		homePage.takeScreenShot(scenario);
		stopRecorder();
		homePage.clear();
	}

}
