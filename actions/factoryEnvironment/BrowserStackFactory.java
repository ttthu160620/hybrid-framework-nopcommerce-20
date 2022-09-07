package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class BrowserStackFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String osVersion;
	
	public BrowserStackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities capality = new DesiredCapabilities();
		capality.setCapability("os", osName);
		capality.setCapability("os_version", osVersion);
		capality.setCapability("browser", browserName);
		capality.setCapability("browser_version", "latest");
		capality.setCapability("browserstack.debug", "true");
		capality.setCapability("project", "NopCommerce");
		capality.setCapability("resolution", "1920x1080");
		capality.setCapability("name", "Run on " + "|" + osName + osVersion + "|" + browserName);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSERSATCK_URL), capality);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
