package co.com.certification.wordcounter.exceptions;

public class ElementPageException extends RuntimeException {
    public static final String ELEMENT_PAGE_FAILED_MESSAGE = "Elemento de la pagina sin interacción";
    public ElementPageException(String message, Throwable cause) {
        super(message, cause);
    }
}
