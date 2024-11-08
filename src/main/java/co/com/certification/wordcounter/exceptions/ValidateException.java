package co.com.certification.wordcounter.exceptions;

public class ValidateException extends AssertionError {
    public static final String WORD_LIST_ERROR_MESSAGE = "Inconsistencia en la lista de palabras con su concurrencia";
    public static final String WORD_COUNT_ERROR_MESSAGE = "Inconsistencia en el conteó de palabras";
    public static final String CHARACTERS_COUNT_ERROR_MESSAGE = "Inconsistencia en el conteó de caracteres";
    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
