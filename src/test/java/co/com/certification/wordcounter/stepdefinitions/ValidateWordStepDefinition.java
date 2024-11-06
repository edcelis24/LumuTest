package co.com.certification.wordcounter.stepdefinitions;

import co.com.certification.wordcounter.exceptions.ValidateException;
import co.com.certification.wordcounter.questions.TheCountCharacters;
import co.com.certification.wordcounter.questions.TheCountWord;
import co.com.certification.wordcounter.questions.TheRepeatedWords;
import co.com.certification.wordcounter.tasks.OpenTheBrowser;
import co.com.certification.wordcounter.tasks.FillEditor;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.certification.wordcounter.exceptions.ValidateException.*;
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

    @After
    public void tearDown() {
        getDriver().quit();
    }

    @When("he enters {int} words text in the editor")
    public void heEntersWordsTextInTheEditor(int wordCount) {
        theActorInTheSpotlight().attemptsTo(
                FillEditor.withText(wordCount)
        );
    }

    @Then("he sees the number of repeated words contained in the text")
    public void heSeesTheNumberOfRepeatedWordsContainedInTheText() {
        theActorInTheSpotlight().should(
                seeThat(TheRepeatedWords.isCorrect()).orComplainWith(ValidateException.class, WORD_LIST_ERROR_MESSAGE)
        );
    }

    @Then("he sees the number of words contained in the text")
    public void heSeesTheNumberOfWordsContainedInTheText() {
        theActorInTheSpotlight().should(
                seeThat(TheCountWord.isCorrect()).orComplainWith(ValidateException.class, WORD_COUNT_ERROR_MESSAGE)
        );
    }

    @Then("he sees the number of characters contained in the text")
    public void heSeesTheNumberOfCharactersContainedInTheText() {
        theActorInTheSpotlight().should(
                seeThat(TheCountCharacters.isCorrect()).orComplainWith(ValidateException.class, CHARACTERS_COUNT_ERROR_MESSAGE)
        );
    }
}
