package addproducttocart;

import commonsteps.CommonSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ExcelReadFile;

public class AddProductToCartSteps {
    String productName;
    HomePage homePage ;
    WhatIsNew whatIsNew;
    Product product;
    ComparsionProductList comparsionProductList;
    ShoppingCart shoppingCart;
    ShippingData shippingData;
    PlaceOrder placeOrder;
    Confirmation confirmation;
    ExcelReadFile excelReadFile;
    String SheetName;
    SoftAssert softAssert = new SoftAssert();
    @Given("navigates to what's new tab")
    public void navigateToWhatIsNew(){
        homePage= CommonSteps.homePage;
        whatIsNew= homePage.clickOnWhatIsNew(CommonSteps.driver);
    }
    @When("add product to comparison and click on compare list")
    public void addProductToComparsionAndClickOnCompareList() throws Exception {
        product=whatIsNew.clickOnProduct();
        product.clickAddToCompare();
        String Message=product.getMessageBarText();
        productName=product.getProductTitle();
        System.out.println(Message);
        softAssert.assertEquals(Message, "You added product " + productName + " to the comparison list.", "Message is not as expected");
        softAssert.assertAll();

    }
    @And("navigates to comparison list and add product to cart")
    public void navigatesToComparisonListAndAddProductToCart() throws Exception {
        comparsionProductList=product.clickOnComparisonList();
        product=comparsionProductList.clickOnAddtoCartButton();
//        String Message=comparsionProductList.getMessageBarText();
//        softAssert.assertEquals(Message, "You added " + productName + " to your shopping cart.", "Message is not as expected");
//        softAssert.assertAll();
    }

    @And ("navigates to cart and proceed to checkout")
    public void navigatesToCartAndProceedToCheckout() throws Exception {
        product.selectColor();
        product.selectSize();
        product.clickAddToCartButton();
        shoppingCart=product.clickOnShoppingCartButton();
        shippingData=shoppingCart.clickOnProceedToCheckout();
    }

    @And ("fill shipping address and payment information based on sentence from row: \"([^\"]*)\"$")
    public void fillShippingAddressAndPaymentInformation(int row) throws Exception {
        excelReadFile = CommonSteps.excelReadFile;
        SheetName="AddingProductToCart";
        String email=excelReadFile.getCellData(SheetName,row,"Email");
        String lastName=excelReadFile.getCellData(SheetName,row,"Lastname");
        String firstName=excelReadFile.getCellData(SheetName,row,"Firstname");
        String address=excelReadFile.getCellData(SheetName,row,"Address");
        String city=excelReadFile.getCellData(SheetName,row,"City");
        String state=excelReadFile.getCellData(SheetName,row,"State");
        String postalCode=excelReadFile.getCellData(SheetName,row,"PostalCode");
        String phoneNumber=excelReadFile.getCellData(SheetName,row,"PhoneNumber");
        shippingData.fillShippingData(email,firstName,lastName,address,city,state,postalCode,phoneNumber);
        placeOrder=shippingData.clickOnNextButton();
    }
    @And("place order")
    public void placeOrder() throws Exception {
        confirmation=placeOrder.placeOrder();
    }

    @Then("verify order created successfully")
    public void verifyOrderCreatedSuccessfully() throws Exception {
       String Message= confirmation.getMessageBarText();
       System.out.println(Message);
        softAssert.assertEquals(Message, "Thank you for your purchase!", "Message is not as expected");
        softAssert.assertAll();
    }

}
