package factoryGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import commons.BrowserList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if(browserList == BrowserList.FIREFOX) {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		
		else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("");
			driver = new ChromeDriver();
		}
		else if(browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver();
			driver = new OperaDriver();
		}
		else {
			throw new RuntimeException("Browser name invalid");
		}
		return driver;
	}
}
