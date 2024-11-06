package co.com.certification.wordcounter.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.certification.wordcounter.userinterfaces.PageContent.SPAN_WORD_COUNT;
import static co.com.certification.wordcounter.util.NumbersConstants.ZERO;
import static co.com.certification.wordcounter.util.SessionVariables.WORD_COUNT;
import static co.com.certification.wordcounter.util.screens.EditorResumeScreen.getTextStructureSummaryFront;


public class TheCountWord implements Question<Boolean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TheCountWord.class);
    public static Question<Boolean> isCorrect() {
        return new Question<>() {
            @Override
            public Boolean answeredBy(Actor actor) {

                String wordsCountFront = Text.of(SPAN_WORD_COUNT).answeredBy(actor);
                String wordsCountSession = Serenity.sessionVariableCalled(WORD_COUNT.getVariableName());
                String wordsCountSummaryFront = getTextStructureSummaryFront(actor).get(ZERO.getNumber());
                try {
                    return wordsCountFront.equals(wordsCountSession) && wordsCountSession.equals(wordsCountSummaryFront);
                } catch (AssertionError e) {
                    LOGGER.error("Información inconsistente:\n"+e.getMessage());
                }
                return null;
            }
            @Override
            public String getSubject() {
                return "The Count Words - Count Words Content Is Validate";
            }
        };
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return false;
    }
}
