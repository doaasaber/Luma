package createnewaccount;

import commonsteps.BaseCognitiveRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"createnewaccount", "commonsteps"},
        features = {"src/test/java/createnewaccount/createnewaccount.feature"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
        ,monochrome = true)
public class CreateNewAccountRunner extends BaseCognitiveRunner {

 }
