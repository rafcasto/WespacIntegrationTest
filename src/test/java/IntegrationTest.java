import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",plugin = {"pretty","html:target/report/index.html","json:target/report/cucumber.json"},monochrome = false)
public class IntegrationTest
{

}
