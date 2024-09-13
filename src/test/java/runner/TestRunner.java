package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/search.feature",
        glue = "step",
        dryRun = !true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {

}
