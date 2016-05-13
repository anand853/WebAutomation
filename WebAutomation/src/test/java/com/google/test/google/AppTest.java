package com.google.test.google;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	String url = "http://www.irobot.com";
	WebDriver idriver;
	Runner runner = new Runner();

	@Test
	public void startBrowser() {
		runner.lauchDriver("chrome");

	}

	@Test
	public void gotoPage() {
		runner.getToPage(url);
		runner.mazimizePage();

	}

	@Test
	public void getTheTitleOfThePage() {
		String title = runner.getPageTitle();
		Assert.assertEquals(title, "iRobot: Your Partner for a Cleaner Home");

	}

	@Test
	public void checkCompanyLogo() {
		boolean flag = runner.isElementDisplayedInThePage("id", "phlogo_0_imgLogo");
		Assert.assertEquals(flag, true);

	}

	@Test
	public void checkTheHome() {
		boolean flag = runner.isElementDisplayedInThePage("xpath",
				"//*[@id='phheader_0_rptNavigation_hypNavigationItem_0']/span");
		Assert.assertEquals(flag, true);

	}

	@Test
	public void checkForBussiness() {
		boolean flag = runner.isElementDisplayedInThePage("xpath",
				"//*[@id='phheader_0_rptNavigation_hypNavigationItem_1']/span");
		Assert.assertEquals(flag, true);

	}

	@Test
	public void checkAboutRobot() {
		boolean flag = runner.isElementDisplayedInThePage("xpath",
				"//*[@id='phheader_0_rptNavigation_hypNavigationItem_2']/span");
		Assert.assertEquals(flag, true);

	}

	@Test
	public void checkCompanyInfomation() {
		boolean flag = runner.isElementDisplayedInThePage("xpath",
				"//*[@id='phprimarynav_0_rptNavigation_hypNavigationItem_0']/span");
		Assert.assertEquals(flag, true);
	}

	@Test
	public void hoverOnCompanyInformation() {
		runner.hoverOnElement("xpath", "//*[@id='phprimarynav_0_rptNavigation_hypNavigationItem_0']/span");

	}

	@Test
	public void hoverOnVaccuming() {
		boolean flag = runner.isElementDisplayedInThePage("xpath",
				"//*[@id='phprimarynav_0_rptNavigation_hypNavigationItem_0']/span");
		Assert.assertEquals(flag, true);
	}
}
