package co.com.certification.wordcounter.interactions;

import co.com.certification.wordcounter.exceptions.ElementPageException;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.certification.wordcounter.exceptions.ElementPageException.ELEMENT_PAGE_FAILED_MESSAGE;
import static co.com.certification.wordcounter.userinterfaces.PageContent.INPUT_EDITOR;

@AllArgsConstructor
public class EnterText implements Interaction {
    private String text;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                Enter.theValue(text).into(INPUT_EDITOR)
            );
        } catch (Exception e) {
            throw new ElementPageException(ELEMENT_PAGE_FAILED_MESSAGE, e);
        }
    }

    public static EnterText inTheEditor(String text) {
        return Tasks.instrumented(EnterText.class, text);
    }
}
