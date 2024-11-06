package co.com.certification.wordcounter.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SessionVariables {
    MAP_WORDS("Words", "Lista de palabras"),
    WORD_COUNT("Count", "Cantidad de palabras"),
    CHARACTERS_COUNT("Characters", "Cantidad de caracteres"),
    ;
    private final String variableName;
    private final String variableDescription;
}
