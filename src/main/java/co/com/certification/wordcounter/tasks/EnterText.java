package co.com.certification.wordcounter.tasks;

import co.com.certification.wordcounter.exceptions.ElementPageException;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static co.com.certification.wordcounter.exceptions.ElementPageException.ELEMENT_PAGE_FAILED_MESSAGE;
import static co.com.certification.wordcounter.userinterfaces.PageContent.INPUT_EDITOR;
import static co.com.certification.wordcounter.util.RandomTextGenerator.generateRandomTextWithDuplicates;
import static co.com.certification.wordcounter.util.SessionVariables.MAP_WORDS;

public class EnterText implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnterText.class);
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            String text = generateRandomTextWithDuplicates(10);
            actor.attemptsTo(
                    Enter.theValue(text).into(INPUT_EDITOR)
            );
        } catch (Exception e) {
            throw new ElementPageException(ELEMENT_PAGE_FAILED_MESSAGE, e);
        }
    }

    public static EnterText inTheEditor() {
        return Tasks.instrumented(EnterText.class);
    }
}
