package co.com.certification.wordcounter.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SessionVariables {
    MAP_WORDS("Words", "Mapa de palabras y su frecuencia"),
    ;
    private final String variableName;
    private final String variableDescription;
}
