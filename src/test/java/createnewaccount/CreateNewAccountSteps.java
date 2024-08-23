package createnewaccount;

import commonsteps.CommonSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.CreateNewAccount;
import pages.CreatedAccount;
import pages.HomePage;
import utilities.ExcelReadFile;

public class CreateNewAccountSteps {
    CreateNewAccount createNewAccount;
    HomePage homePage ;
    CreatedAccount createdAccount;
    ExcelReadFile excelReadFile;
    String SheetName;

    SoftAssert softAssert = new SoftAssert();

    @Given("navigates to create new account tab")
    public void navigatesToCreateNewAccountTab() throws Exception {
        homePage=CommonSteps.homePage;
        createNewAccount= homePage.createNewAccount(CommonSteps.driver);

    }

    @When("fill all the required data based on sentence from row: \"([^\"]*)\"$")
    public void fillAllRequiredData(int row ) throws Exception {
        excelReadFile = CommonSteps.excelReadFile;
        SheetName="CreatingNewAccount";
        String firstName=excelReadFile.getCellData(SheetName,row,"Firstname");
        String lastName=excelReadFile.getCellData(SheetName,row,"Lastname");
        String email=excelReadFile.getCellData(SheetName,row,"Email");
        String password=excelReadFile.getCellData(SheetName,row,"Password");
        String confirmPassword=excelReadFile.getCellData(SheetName,row,"ConfirmPassword");
        createNewAccount.fillData(firstName,lastName,email,password,confirmPassword);

    }

    @And("click on create account")
    public void clickOnCreateAccount() throws Exception {
        createdAccount= createNewAccount.clickOnCreateButton();
    }

    @Then("validate creating account successfully")
    public void validateCreatingAccountSuccessfully() throws Exception {
        softAssert.assertEquals(createdAccount.createdMessageText(), "Thank you for registering with Main Website Store.", "Message is not as expected");
        softAssert.assertAll();
    }

}
