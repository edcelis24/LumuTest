package co.com.certification.wordcounter.exceptions;

public class FuntionalException extends RuntimeException {
    public static final String ENTER_TEXT_FAILED_MESSAGE = "Error al momento de ingresar texto en el editor";
    public FuntionalException(String message, Throwable cause) {
        super(message, cause);
    }
}
