package co.com.certification.wordcounter.util;


import co.com.certification.wordcounter.models.WordCount;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static co.com.certification.wordcounter.util.SessionVariables.MAP_WORDS;

public class RandomTextGenerator {

    // Método para generar texto aleatorio **con duplicados** utilizando Apache Commons Lang
    public static String generateRandomTextWithDuplicates(int wordCount) {
        List<String> words = new ArrayList<>();
        List<WordCount> wordCountList = new ArrayList<>();  // Lista de objetos WordCount
        Random random = new Random();

        // Generamos las palabras aleatorias, algunas de ellas se duplicarán
        for (int i = 0; i < wordCount; i++) {
            String word = generateRandomWord();

            // Convertimos la palabra a minúsculas
            word = word.toLowerCase();

            // Generar un número aleatorio para decidir si agregamos la palabra repetida
            if (random.nextBoolean() && words.size() > 0) {
                // Probabilidad de repetir palabras, agregando aleatoriamente algunas de las palabras previas
                word = words.get(random.nextInt(words.size())).toLowerCase();  // Aseguramos que también esté en minúsculas
            }

            // Agregamos la palabra a la lista de palabras
            words.add(word);

            // Buscamos si la palabra ya está en la lista de WordCount
            boolean found = false;
            for (WordCount wc : wordCountList) {
                if (wc.getWord().equals(word)) {
                    wc.incrementCount();  // Incrementamos el contador de la palabra
                    found = true;
                    break;
                }
            }


            // Si no la encontramos, la agregamos a la lista
            if (!found) {
                wordCountList.add(new WordCount(word));
            }
        }

        // Concatenamos todas las palabras para formar el texto
        StringBuilder randomText = new StringBuilder();
        for (String word : words) {
            randomText.append(word).append(" ");
        }


        // Mostrar todas las palabras y sus cantidades
        System.out.println("Todas las palabras y sus cantidades:");
        for (WordCount wc : wordCountList) {
            System.out.println(wc);  // Imprimimos la palabra y su frecuencia
        }
        Collections.sort(wordCountList);
        // Si se requiere almacenar el resultado en una variable de sesión, se puede hacer aquí.
        Serenity.setSessionVariable(MAP_WORDS.getVariableName()).to(wordCountList);
        return randomText.toString().trim();
    }

    private static String generateRandomWord() {
        // Generamos una palabra aleatoria de longitud entre 5 y 10 caracteres
        int length = new Random().nextInt(4) + 3;  // Longitud aleatoria entre 5 y 10
        return RandomStringUtils.randomAlphabetic(length);  // Genera una palabra alfabética aleatoria
    }
}
