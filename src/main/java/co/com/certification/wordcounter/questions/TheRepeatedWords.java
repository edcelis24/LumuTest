package co.com.certification.wordcounter.questions;

import co.com.certification.wordcounter.models.WordCount;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.com.certification.wordcounter.util.SessionVariables.MAP_WORDS;
import static co.com.certification.wordcounter.util.screens.EditorResumeScreen.getWordsListFront;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionComparatorMode.LENIENT_ORDER;


public class TheRepeatedWords implements Question<Boolean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TheRepeatedWords.class);
    public static Question<Boolean> isCorrect() {
        return new Question<>() {
            @Override
            public Boolean answeredBy(Actor actor) {

                List<WordCount> wordsListText = Serenity.sessionVariableCalled(MAP_WORDS.getVariableName());
                List<WordCount> wordsListFront = getWordsListFront(actor);

                try {
                    assertReflectionEquals(wordsListText, wordsListFront, LENIENT_ORDER);
                    return true;
                } catch (AssertionError e) {
                    LOGGER.error("Información inconsistente:\n"+e.getMessage());
                }
                return null;
            }
            @Override
            public String getSubject() {
                return "The Repeated Words - Repeated Words Content Is Validate";
            }
        };
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return false;
    }
}
