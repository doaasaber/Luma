package commonsteps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CreateNewAccount;
import pages.CreatedAccount;
import pages.HomePage;
import utilities.DriverSetUp;

public class BaseCognitiveRunner extends AbstractTestNGCucumberTests {
    static WebDriver driver;
    static HomePage homePage;
    static CreateNewAccount createNewAccount;
    CreatedAccount createdAccount;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void initiateTest() throws Exception {
        driver=DriverSetUp.driverInitiate();
        homePage = new HomePage(driver);

    }
    @AfterMethod
    public void endTest(){
        driver.quit();
    }

}
