package co.com.certification.wordcounter.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.certification.wordcounter.userinterfaces.PageContent.SPAN_CHARACTERS_COUNT;
import static co.com.certification.wordcounter.util.NumbersConstants.TWO;
import static co.com.certification.wordcounter.util.SessionVariables.CHARACTERS_COUNT;
import static co.com.certification.wordcounter.util.screens.EditorResumeScreen.getTextStructureSummaryFront;


public class TheCountCharacters implements Question<Boolean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TheCountCharacters.class);
    public static Question<Boolean> isCorrect() {
        return new Question<>() {
            @Override
            public Boolean answeredBy(Actor actor) {

                String charactersCountFront = Text.of(SPAN_CHARACTERS_COUNT).answeredBy(actor);
                String charactersCountSession = Serenity.sessionVariableCalled(CHARACTERS_COUNT.getVariableName());
                String charactersCountSummaryFront = getTextStructureSummaryFront(actor).get(TWO.getNumber());
                try {
                    return charactersCountFront.equals(charactersCountSession) && charactersCountSession.equals(charactersCountSummaryFront);
                } catch (AssertionError e) {
                    LOGGER.error("Información inconsistente:\n"+e.getMessage());
                }
                return null;
            }
            @Override
            public String getSubject() {
                return "The Count Characters - Count Characters Content Is Validate";
            }
        };
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return false;
    }
}
