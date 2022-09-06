package commons;

import java.io.File;

public class GlobalConstants {
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.pathSeparator + "uploadFiles" + File.pathSeparator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.pathSeparator + "downloadFiles" + File.pathSeparator;
	public static final String REPORTNG_SCREENSHOTS = PROJECT_PATH + File.pathSeparator + "ReportNGScreenShots" + File.pathSeparator;
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.pathSeparator + "browserLogs";
	public static final String DRAG_DROP_HTML = PROJECT_PATH + File.pathSeparator + "";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.pathSeparator + "autoIT";
	public static final String JAVA_VERSION = System.getProperty("java.version");
	
	//DB Acount/ User/ Pass/ Port
	public static final String DB_DEV_URL = "";
	public static final String DB_DEV_USER = "";
	public static final String DB_DEV_PASS = "";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TESTCASE_FAIL= 5;
	
	public static final String BROWSERSATCK_USERNAME = "thtrn_kXAsdb";
	public static final String BROWSERSATCK_ACCESS_KEY = "UasaHYzbafhjdn1SS18q";
	public static final String BROWSERSATCK_URL = "https://" + BROWSERSATCK_USERNAME + ":" + BROWSERSATCK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCELAP_USERNAME = "oauth-minhthu160620-631e3";
	public static final String SAUCELAP_ACCESS_KEY = "c0e9bd61-13bc-4877-8d1f-96ac46b2b3ee";
	public static final String  SAUCELAP_URL = "https://" + SAUCELAP_USERNAME +":" + SAUCELAP_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
}
