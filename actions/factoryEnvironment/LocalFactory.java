package factoryEnvironment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.CocCocDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FireFoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		if(browser == BrowserList.FIREFOX) {
			 driver = new FireFoxDriverManager().getBrowserDriver();
		}
		else if (browser == BrowserList.EDGE) {
			driver = new EdgeDriverManager().getBrowserDriver();
		}
		else if(browser == BrowserList.CHROME) {
			driver = new ChromeDriverManager().getBrowserDriver();
		}
		else if(browser == BrowserList.COCCOC) {
			driver = new CocCocDriverManager().getBrowserDriver();
		}
		else if(browser == BrowserList.OPERA) {
			driver = new OperaDriverManager().getBrowserDriver();
		}
		else if(browser == BrowserList.H_CHROME) {
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
		}
		else {
			throw new BrowserNotSupportedException(browserName);
		}
		return driver;
	}
}
