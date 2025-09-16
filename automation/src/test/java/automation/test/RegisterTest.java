package automation.test;
import org.junit.BeforeClass;
import org.junit.Test;
import automation.pages.LoginPO;
import automation.pages.RegisterPO;

/**
 * Class for the register products tests
 */

public class RegisterTest extends BaseTest {
        private static LoginPO loginPage;
        private static RegisterPO registerPage;

        @BeforeClass
    public static void prepareTests(){
        loginPage = new LoginPO(driver);
        registerPage = new RegisterPO(driver);
    }

    @Test
    public void TC01_Register_a_product_with_success() {
        loginPage.login("admin@admin.com", "admin@123");
        registerPage.verifyIfProductRegisterPageLoads();
        registerPage.registerProduct("123", "Test Product", "10", "99", "05/09/2025");
        registerPage.verifyIfProductWasCorrectlyRegistered("123", "Test Product", "10", "99", "2025-09-05");

    }
}
