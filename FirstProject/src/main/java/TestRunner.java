@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/reports/cucumber.html", "json:target/reports/cucumber.json"}, features = "src/test/resources/", tags = "not @ignore", snippets = CucumberOptions.SnippetType.CAMELCASE)
public class TestRunner{

}