package automation.test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automation.pages.LoginPO;
import automation.pages.RegisterPO;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


/**
 * Class of login tests
 */
public class LoginTest extends BaseTest {
        private static LoginPO loginPage;
        private static RegisterPO registerPage;

    @BeforeClass
    public static void prepareTests(){
        loginPage = new LoginPO(driver);
        registerPage = new RegisterPO(driver);
    }

    

        @Test
    public void TC01_Should_not_have_log_into_system_with_empty_email_and_password() {
        loginPage.login("", "");
        String message = loginPage.obtainMessage();
        assert message.equals("Informe usuário e senha, os campos não podem ser brancos.");
    }

            @Test
    public void TC02_Should_not_have_log_into_system_with_empty_password() {
        loginPage.login("admin@admin.com", "");
        String message = loginPage.obtainMessage();
        assert message.equals("Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC03_Should_not_have_log_into_system_with_empty_email() {
        loginPage.login("", "wrongpassword");
        String message = loginPage.obtainMessage();
        assert message.equals("Informe usuário e senha, os campos não podem ser brancos.");
    }

        @Test
    public void TC04_Should_not_have_log_into_system_with_wrong_credentials() {
        loginPage.login("test", "test");
        String message = loginPage.obtainMessage();
        assert message.equals("E-mail ou senha inválidos");
    }

            @Test
    public void TC05_Should_not_have_log_into_system_with_wrong_password() {
        loginPage.login("admin@admin.com", "test");
        String message = loginPage.obtainMessage();
        assert message.equals("E-mail ou senha inválidos");
    }

                @Test
    public void TC06_Should_not_have_log_into_system_with_wrong_email() {
        loginPage.login("adminn@admin.com", "admin@123");
        String message = loginPage.obtainMessage();
        assert message.equals("E-mail ou senha inválidos");
    }

                    @Test
    public void TC07_Should_log_into_system_with_success() {
        loginPage.login("admin@admin.com", "admin@123");
        registerPage.verifyIfProductRegisterPageLoads();
    }



}
