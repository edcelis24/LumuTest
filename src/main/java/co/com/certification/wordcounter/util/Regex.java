package co.com.certification.wordcounter.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Regex {
    REGEX_PORCENT("\\([^)]*\\)"),
    REGEX_SPACE("\\s+"),
    REGEX_ADD_SPACE(" "),
    ;
    private final String content;
}
