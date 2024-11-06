package co.com.certification.wordcounter.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NumbersConstants {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    TEN(10),
    ONE_THOUSAND_FIVE_HUNDRED(1500),
    ;
    private final int number;
}
