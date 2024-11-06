package co.com.certification.wordcounter.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class PageContent extends PageObject {
    public static final Target INPUT_EDITOR = Target.the("Input - Editor text").located(By.id("box"));
    public static final Target SPAN_REPEATED_WORD = Target.the("Span - List repeated word").locatedBy("//div[@id='kwd-accordion-data']//a[@class='list-group-item']//span[@class='word']");
    public static final Target SPAN_NUMBER_REPETITIONS = Target.the("Span - List number repetitions").locatedBy("//div[@id='kwd-accordion-data']//a[@class='list-group-item']//span[@class='badge']");
}
