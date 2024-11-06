package co.com.certification.wordcounter.util;


import co.com.certification.wordcounter.models.WordCount;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static co.com.certification.wordcounter.util.NumbersConstants.*;
import static co.com.certification.wordcounter.util.Regex.REGEX_ADD_SPACE;
import static co.com.certification.wordcounter.util.SessionVariables.MAP_WORDS;

public class RandomTextGenerator {

    public static String generateRandomTextWithDuplicates(int wordCount) {
        List<String> words = new ArrayList<>();
        List<WordCount> wordCountList = new ArrayList<>();
        Random random = new Random();

        for (int i = ZERO.getNumber(); i < wordCount; i++) {
            String word = generateRandomWord();
            word = word.toLowerCase();

            if (random.nextBoolean() && !words.isEmpty()) {
                word = words.get(random.nextInt(words.size())).toLowerCase();
            }

            words.add(word);

            boolean found = false;
            for (WordCount wc : wordCountList) {
                if (wc.getWord().equals(word)) {
                    wc.incrementCount();
                    found = true;
                    break;
                }
            }

            if (!found) {
                wordCountList.add(new WordCount(word));
            }
        }

        StringBuilder randomText = new StringBuilder();
        for (String word : words) {
            randomText.append(word).append(REGEX_ADD_SPACE.getContent());
        }

        Collections.sort(wordCountList);

        if (wordCountList.size() > TEN.getNumber()) {
            wordCountList = wordCountList.subList(ZERO.getNumber(), TEN.getNumber());
        }

        Serenity.setSessionVariable(MAP_WORDS.getVariableName()).to(wordCountList);

        return randomText.toString().trim();
    }

    private static String generateRandomWord() {
        int length = new Random().nextInt(FOUR.getNumber()) + THREE.getNumber();
        return RandomStringUtils.randomAlphabetic(length);
    }
}
