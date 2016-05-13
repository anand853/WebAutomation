package com.google.test.google;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Runner {

	Runner runner;
	WebDriver driver;
	WebElement element;
	String osName;
	String driverPath;
	List<WebElement> elementList;
	String result = "";
	InputStream inputStream;

	public String getOSVersion() {
		return System.getProperty("os.name");

	}

	public static void main(String[] args) {
		Runner r = new Runner();
		try {
			r.getPropValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("path.separator"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("line.separator"));
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.vendor.url"));
		System.out.println(System.getProperty("java.vendor"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(System.getProperty("file.separator"));

		System.out.println(r.getOSVersion());
	}

	public WebDriver lauchDriver(String browser) {

		osName = getOSVersion();
		if (osName.equalsIgnoreCase("Windows 10")) {
			driverPath = "C:\\Building\\WebDriver\\drivers\\chromedriver_win32\\chromedriver.exe";
		} else {
			driverPath = "/usr/local/bin/chromedriver";
		}

		System.setProperty("webdriver.chrome.driver", driverPath);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	public void getToPage(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public boolean isElementDisplayedInThePage(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(string2)).isDisplayed();
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(string2)).isDisplayed();
		}
		return false;

	}

	public boolean isElementEnabledInThePage(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(string2)).isEnabled();
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(string2)).isEnabled();
		}
		return false;

	}

	public void closeBrowser() {
		driver.close();

	}

	public void shutDownDriver() {
		driver.quit();

	}

	public WebElement findElement(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(string2));

		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(string2));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(string2));
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(string2));
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			element = driver.findElement(By.className(string2));
		}
		return element;

	}

	public List<WebElement> findElements(String locatorType, String string2) {

		if (locatorType.equalsIgnoreCase("name")) {
			elementList = driver.findElements(By.name(string2));

		}
		if (locatorType.equalsIgnoreCase("id")) {
			elementList = driver.findElements(By.id(string2));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			elementList = driver.findElements(By.cssSelector(string2));
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			elementList = driver.findElements(By.xpath(string2));
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			elementList = driver.findElements(By.className(string2));
		}
		return elementList;

	}

	public void hoverOnElement(String locatorType, String searchTerm) {
		Actions action = new Actions(driver);

		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(searchTerm));
			action.moveToElement(element).build().perform();

		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(searchTerm));
			action.moveToElement(element).build().perform();
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(searchTerm));
			action.moveToElement(element).build().perform();
		}
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(searchTerm));
			action.moveToElement(element).build().perform();
		}
		if (locatorType.equalsIgnoreCase("classname")) {
			element = driver.findElement(By.className(searchTerm));
			action.moveToElement(element).build().perform();
		}

	}

	public void mazimizePage() {
		driver.manage().window().maximize();

	}

	public WebDriver configureWebAppAppium() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "XT1053");
		capabilities.setCapability("platformName", "Android");
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setCapability("device", "android");
		capabilities.setCapability("app", "chrome");
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Building\\WebDriver\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:9512/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

	public WebDriver configureNativeAppAppium() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "XT1053");
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "codepath.apps.demointroandroid");
		capabilities.setCapability("appActivity", "codepath.apps.demointroandroid.DemoSelector");
		capabilities.setCapability("device", "android");

		try {

			driver = new RemoteWebDriver(new URL("http://localhost:9512/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		return driver;

	}

	public String getPropValues() throws IOException {

		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			Date time = new Date(System.currentTimeMillis());

			String user = prop.getProperty("deviceName");
			String company1 = prop.getProperty("platformVersion");
			String company2 = prop.getProperty("platformName");
			String company3 = prop.getProperty("appActivity");

			result = "Company List = " + company1 + ", " + company2 + ", " + company3;
			System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

}
