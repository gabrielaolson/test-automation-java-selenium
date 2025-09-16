package automation.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Login Page Object
 */
public class LoginPO extends BasePO {


    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "senha")
    public WebElement passwordField;

    @FindBy(id = "btn-entrar")
    public WebElement signInButton;

    // @FindBy(id = "mensagem")
    // public WebElement spanMessage;
    @FindBy(css="form.form-login>div.alert>span")
    public WebElement spanMessage;

    /**
     * Constructor for Login Page Object
     * @param driver
     */

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obtainMessage(){
        return spanMessage.getText();
    }



public void login(String email, String password){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(emailField));
    wait.until(ExpectedConditions.visibilityOf(passwordField));
    wait.until(ExpectedConditions.elementToBeClickable(signInButton));

    write(emailField, email);
    write(passwordField, password);
    signInButton.click();
}

    public void write(WebElement input, String text){
        input.clear();
        input.sendKeys(text + Keys.TAB);
    }

}
