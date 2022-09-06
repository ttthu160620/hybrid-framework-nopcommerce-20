package factoryGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class SaucelapFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	
	public SaucelapFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities capality = new DesiredCapabilities();
		capality.setCapability("platformName", osName);
		capality.setCapability("browserName", browserName);
		capality.setCapability("browserVersion", "latest");
		capality.setCapability("name", "Run on" + osName + "|" + browserName);
		
		Map<String, Object> sauceOptions = new HashedMap<>();
		if(osName.contains("Windows")) {
			sauceOptions.put("screenResolution", "1920x1080");
		}
		else {
			sauceOptions.put("screenResolution", "1920x1440");
		}
		
		capality.setCapability("sauce:options", sauceOptions);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELAP_URL), capality);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
