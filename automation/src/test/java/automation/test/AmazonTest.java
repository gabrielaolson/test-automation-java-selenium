package automation.test;
import org.junit.BeforeClass;
import org.junit.Test;
import automation.pages.AmazonPO;


/** Class for the Amazon tests */
public class AmazonTest extends BaseTest {
    

    private static AmazonPO amazonPage;
    @BeforeClass
    public static void prepareTests(){
        driver.get("https://www.amazon.com.br");
        amazonPage = new AmazonPO(driver);
    }

    @Test
    public void TC01_Should_search_iphone_16_on_Amazon() {
        amazonPage.searchProduct("Iphone 16");
        amazonPage.searchResult.isDisplayed();

    }

        @Test
    public void TC02_Should_search_iphone_17_on_Amazon() {
        amazonPage.searchProduct("Iphone 17");
        amazonPage.searchResult.isDisplayed();

    }

}







