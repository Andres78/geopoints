package es.ahs.mygeopoints.util.exception;

/**
 * Created by ahs on 30.05.16.
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data found")  // 404
public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
}
