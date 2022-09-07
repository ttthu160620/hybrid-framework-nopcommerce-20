package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import factoryBrowser.BrowserList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridLocalFactory {
	WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;
	
	public GridLocalFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capality = null;
		
		if(browser == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			capality = DesiredCapabilities.firefox();
			capality.setBrowserName("firefox");
			capality.setPlatform(Platform.ANY);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capality);
		} 
		else if(browser == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			capality = DesiredCapabilities.chrome();
			capality.setBrowserName("chrome");
			capality.setPlatform(Platform.ANY);
			ChromeOptions options = new ChromeOptions();
			options.merge(capality);
		}
		else if(browser == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			capality = DesiredCapabilities.edge();
			capality.setBrowserName("edge");
			capality.setPlatform(Platform.ANY);
			EdgeOptions options = new EdgeOptions();
			options.merge(capality);
		}
		else if(browser == BrowserList.SAFARI) {
			capality = DesiredCapabilities.safari();
			capality.setBrowserName("safari");
			capality.setJavascriptEnabled(true);
			capality.setPlatform(Platform.MAC);
		}
		else if(browser == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("");
			driver = new ChromeDriver();
		}
		else if(browser == BrowserList.OPERA) {
//			WebDriverManager.operadriver();
//			driver = new OperaDriver();
			WebDriverManager.operadriver().setup();
			capality = DesiredCapabilities.opera();
			capality.setBrowserName("opera");
			capality.setPlatform(Platform.ANY);
			OperaOptions options = new OperaOptions();
			options.merge(capality);
		} else {
			throw new RuntimeException("Please input valid browser name value");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capality);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
}
