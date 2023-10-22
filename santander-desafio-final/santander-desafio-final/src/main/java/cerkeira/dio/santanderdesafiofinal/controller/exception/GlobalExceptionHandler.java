package cerkeira.dio.santanderdesafiofinal.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException businessException) {
		
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
		
		return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnxpectedException(Throwable unxpectedException) {
		var message = "Unxpected server error, please see the logs.";
		logger.error(message, unxpectedException);
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
