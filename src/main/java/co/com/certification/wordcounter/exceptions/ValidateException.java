package co.com.certification.wordcounter.exceptions;

public class ValidateException extends AssertionError {
    public static final String WORD_LIST_ERROR_MESSAGE = "Inconsistencia en la lista de palabras con su concurrencia";
    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
