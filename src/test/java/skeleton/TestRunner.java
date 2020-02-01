package skeleton;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import utils.MyCucumber;

@RunWith(MyCucumber.class)
@CucumberOptions(
        features = {"target/TestsImportedFromJira"},
        plugin = {"pretty" ,"json:target/cucumber.json"}
)
public class TestRunner {

}