package automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/** This is the base class for creation of new Page Objects 
 * All pages should extend this class
*/
public abstract class BasePO {
    /** Base driver that will be used by pages */
    protected WebDriver driver;

    /**
     * Constructor for creation of elements fabric BasePO
     * Driver of actual page
     * @param driver
     */

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
