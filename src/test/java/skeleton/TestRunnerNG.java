package skeleton;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;
import utils.listeners.ListenerNG;

@Listeners(ListenerNG.class)
@CucumberOptions(
        features = {"target/TestsImportedFromJira"},
        plugin = {"pretty" ,"json:target/cucumber.json"}
)
public class TestRunnerNG extends AbstractTestNGCucumberTests {

}