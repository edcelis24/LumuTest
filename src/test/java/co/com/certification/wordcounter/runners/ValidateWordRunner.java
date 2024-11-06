package co.com.certification.wordcounter.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/validate_word.feature",
        glue = "co.com.certification.wordcounter.stepdefinitions",
        tags = "@testLocal",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ValidateWordRunner {
}
