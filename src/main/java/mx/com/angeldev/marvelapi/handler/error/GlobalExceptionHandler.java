package mx.com.angeldev.marvelapi.handler.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOG = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
		LOG.error("Ocurrió un error en la aplicación: ", e);
        String errorMessage = "Ocurrió un error en la aplicación: " + e.getMessage();
        
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
