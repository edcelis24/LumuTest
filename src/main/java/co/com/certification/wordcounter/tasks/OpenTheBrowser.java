package co.com.certification.wordcounter.tasks;

import co.com.certification.wordcounter.exceptions.OpenTheBrowserException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.TimeoutException;

import static co.com.certification.wordcounter.exceptions.OpenTheBrowserException.DRIVER_FAILED_MESSAGE;
import static co.com.certification.wordcounter.exceptions.OpenTheBrowserException.TECHNICAL_FAILED_MESSAGE;

public class OpenTheBrowser implements Task {
    public static OpenTheBrowser onWordCounter() {
        return Tasks.instrumented(OpenTheBrowser.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            String url = "https://wordcounter.net/";
            actor.attemptsTo(
                    Open.url(url)
            );
        } catch (TimeoutException e) {
            throw new OpenTheBrowserException(DRIVER_FAILED_MESSAGE, e);
        } catch (Exception e) {
            throw new OpenTheBrowserException(TECHNICAL_FAILED_MESSAGE, e);
        }
    }
}
