package co.com.certification.wordcounter.stepdefinitions;

import co.com.certification.wordcounter.exceptions.ValidateException;
import co.com.certification.wordcounter.questions.TheRepeatedWords;
import co.com.certification.wordcounter.tasks.OpenTheBrowser;
import co.com.certification.wordcounter.tasks.EnterText;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.certification.wordcounter.exceptions.ValidateException.WORD_LIST_ERROR_MESSAGE;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateWordStepDefinition {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user opens the WordCounter page")
    public void thatTheUserOpensTheWordCounterPage() {
        theActorCalled("David").wasAbleTo(
            OpenTheBrowser.onWordCounter()
        );
    }
    @When("he enters text in the editor")
    public void heEntersTextInTheEditor() {
        theActorInTheSpotlight().attemptsTo(
            EnterText.inTheEditor()
        );
    }
    @Then("he sees the number of words contained in the text")
    public void heSeesTheNumberOfWordsContainedInTheText() {
        theActorInTheSpotlight().should(
                seeThat(TheRepeatedWords.isCorrect()).orComplainWith(ValidateException.class, WORD_LIST_ERROR_MESSAGE)
        );
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }
}
