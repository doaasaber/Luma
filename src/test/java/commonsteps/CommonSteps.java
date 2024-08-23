package commonsteps;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.DriverSetUp;
import utilities.ExcelReadFile;
import utilities.ReportSetUp;


public class CommonSteps {
    public static WebDriver driver;
    public static Scenario scenario;
    public static HomePage homePage;
    public static ExcelReadFile excelReadFile;


    @Before
    public void browserInitialization(Scenario scenario) throws Exception {
        CommonSteps.scenario = scenario;
        driver = DriverSetUp.driver;
        homePage=new HomePage(driver);
        CommonSteps.excelReadFile = new ExcelReadFile("input.xlsx");

    }
    @AfterStep
    public void addScreenshot(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            ReportSetUp.addScreenshotAndLogStep(scenario, "Step Failed", CommonSteps.driver);
            CommonSteps.driver.navigate().refresh();

        }
    }


}
