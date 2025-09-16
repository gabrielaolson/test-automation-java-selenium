package automation.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Register Page Object
 */
public class RegisterPO extends BasePO {
        public RegisterPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Controle de produtos']")
    public WebElement productRegisterTitlePage;

    @FindBy(xpath = "//a[text()='Voltar']")
    public WebElement backButton;

    @FindBy(id = "btn-adicionar")
    public WebElement createButton;

    @FindBy(xpath = "//h4[contains(text(),'Produto')]")
    public WebElement productRegisterModalHeader;

    @FindBy(id = "codigo")
    public WebElement productCodeInput;

    @FindBy(id = "nome")
    public WebElement productNameInput;

    @FindBy(id = "quantidade")
    public WebElement productQuantityInput;

    @FindBy(id = "valor")
    public WebElement productPriceInput;

    @FindBy(id = "data")
    public WebElement productDateInput;

    @FindBy(id = "btn-salvar")
    public WebElement saveButton;

    @FindBy(id = "btn-sair")
    public WebElement exitButton;

    @FindBy(xpath = "//button[contains(@class, 'close')]")
    public WebElement closeButton;



    public void verifyIfProductRegisterPageLoads() {
        assertTrue(this.productRegisterTitlePage.isDisplayed());
    }   

    public void clickCreateButton() {
        createButton.click();
    }

    public void fillProductForm(String code, String name, String quantity, String price, String date) {
        productCodeInput.sendKeys(code);
        productNameInput.sendKeys(name);
        productQuantityInput.sendKeys(quantity);
        productPriceInput.sendKeys(price);
        productDateInput.sendKeys(date);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void registerProduct(String code, String name, String quantity, String price, String date) {
        clickCreateButton();
        clickCreateButton();
        fillProductForm(code, name, quantity, price, date);
        clickSaveButton();
        clickCloseButton();
    }

public void verifyIfProductWasCorrectlyRegistered(String code, String name, String quantity, String price, String date) {
    WebElement registeredProductCode = driver.findElement(By.xpath("//td[text()='" + code + "']"));
    WebElement registeredProductName = driver.findElement(By.xpath("//td[text()='" + name + "']"));
    WebElement registeredProductQuantity = driver.findElement(By.xpath("//td[text()='" + quantity + "']"));
    WebElement registeredProductPrice = driver.findElement(By.xpath("//td[text()='" + price + "']"));
    WebElement registeredProductDate = driver.findElement(By.xpath("//td[text()='" + date + "']"));

    
    assertTrue(registeredProductCode.isDisplayed());
    assertTrue(registeredProductName.isDisplayed());
    assertTrue(registeredProductQuantity.isDisplayed());
    assertTrue(registeredProductPrice.isDisplayed());
    assertTrue(registeredProductDate.isDisplayed());
}

}
