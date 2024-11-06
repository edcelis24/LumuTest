package co.com.certification.wordcounter.util.screens;

import co.com.certification.wordcounter.models.WordCount;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;

import java.util.ArrayList;
import java.util.List;

import static co.com.certification.wordcounter.userinterfaces.PageContent.SPAN_NUMBER_REPETITIONS;
import static co.com.certification.wordcounter.userinterfaces.PageContent.SPAN_REPEATED_WORD;
import static co.com.certification.wordcounter.util.Regex.REGEX_PORCENT;
import static co.com.certification.wordcounter.util.Regex.REGEX_SPACE;

public class EditorResumeScreen {
    public static List<WordCount> getWordsListFront(Actor actor) {
        List<WebElementFacade> repeated_word = SPAN_REPEATED_WORD.resolveAllFor(actor);
        List<WebElementFacade> number_repitions = SPAN_NUMBER_REPETITIONS.resolveAllFor(actor);
        List<WordCount> wordList = new ArrayList<>();

        for (int i = 0; i < repeated_word.size(); i++) {
            String word = repeated_word.get(i).getText();
            int count = Integer.parseInt(number_repitions.get(i).getText().replaceAll(REGEX_PORCENT.getContent(), "").replaceAll(REGEX_SPACE.getContent(), ""));
            WordCount operation = new WordCount(word, count);
            wordList.add(operation);
        }
        return wordList;
    }
}