package co.com.certification.wordcounter.tasks;

import co.com.certification.wordcounter.exceptions.FuntionalException;
import co.com.certification.wordcounter.interactions.EnterText;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.certification.wordcounter.exceptions.FuntionalException.ENTER_TEXT_FAILED_MESSAGE;
import static co.com.certification.wordcounter.util.NumbersConstants.ONE_THOUSAND_FIVE_HUNDRED;
import static co.com.certification.wordcounter.util.RandomTextGenerator.generateRandomTextWithDuplicates;
import static co.com.certification.wordcounter.util.SessionVariables.CHARACTERS_COUNT;
import static co.com.certification.wordcounter.util.SessionVariables.WORD_COUNT;

@AllArgsConstructor
public class FillEditor implements Task {
    private int wordCount;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            String text = generateRandomTextWithDuplicates(wordCount);
            Serenity.setSessionVariable(WORD_COUNT.getVariableName()).to(String.valueOf(wordCount));
            Serenity.setSessionVariable(CHARACTERS_COUNT.getVariableName()).to(String.valueOf(text.length()));

            actor.attemptsTo(EnterText.inTheEditor(text));

            try {
                Thread.sleep(ONE_THOUSAND_FIVE_HUNDRED.getNumber());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            throw new FuntionalException(ENTER_TEXT_FAILED_MESSAGE, e);
        }
    }

    public static FillEditor withText(int wordCount) {
        return Tasks.instrumented(FillEditor.class, wordCount);
    }
}
