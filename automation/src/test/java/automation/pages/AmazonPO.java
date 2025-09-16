package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Amazon Page Object
 */
public class AmazonPO extends BasePO {

    @FindBy(name = "field-keywords")
    public WebElement searchBox;

    @FindBy(css="h2.a-size-medium-plus.a-spacing-none.a-color-base.a-text-bold")
    public WebElement searchResult;

    public AmazonPO(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.submit();
    }
    
}
