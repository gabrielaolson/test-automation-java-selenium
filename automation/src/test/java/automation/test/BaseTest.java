package automation.test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/** 
 * Base class that sets up and tears down the WebDriver for all the tests(heritage for all classes).
 */

public abstract class BaseTest {
        protected static WebDriver driver;
        private final static String CHROME_DRIVER_PATH = "src/test/java/automation/resource/chromedriver";
        private final static String CHROME_BINARY_PATH = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        protected final static String BASE_URL = "automation/sistema/login.html";
        // "https://www.amazon.com.br";

        @BeforeClass
        public static void setUp() {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(CHROME_BINARY_PATH
            );
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get(BASE_URL);
        }

        @AfterClass
        public static void tearDown() {
            if (driver != null) driver.quit();
        }

    }

