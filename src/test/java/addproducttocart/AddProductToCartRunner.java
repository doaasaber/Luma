package addproducttocart;
import commonsteps.BaseCognitiveRunner;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(glue = {"addproducttocart", "commonsteps"},
        features = {"src/test/java/addproducttocart/addproducttocart.feature"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        monochrome = true)
public class AddProductToCartRunner extends BaseCognitiveRunner {
}
