package co.com.certification.wordcounter.exceptions;

public class OpenTheBrowserException extends RuntimeException {
    public static final String DRIVER_FAILED_MESSAGE = "Tiempo de espera excedido para el sitio web.";
    public static final String TECHNICAL_FAILED_MESSAGE = "Ocurrió un error inesperado al intentar abrir el navegador.";
    public OpenTheBrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}
