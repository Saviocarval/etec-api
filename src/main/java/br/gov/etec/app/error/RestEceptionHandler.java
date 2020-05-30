package br.gov.etec.app.error;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class RestEceptionHandler{
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({NoHandlerFoundException.class}) 
	public void handleNotFound(){ 
		 
	}
	
	@ExceptionHandler({SQLException.class, DataIntegrityViolationException.class, ConstraintViolationException.class})
	protected ResponseEntity<ErrorResponse> handleSqlExeption(ConstraintViolationException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getSQLException().getMessage(), ex.getErrorCode(), ex.getSQLException().getSQLState(), ex.getConstraintName());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
				
	@ExceptionHandler({MethodArgumentNotValidException.class})
	protected ResponseEntity<BindingResult> handleArgumentNotValid(MethodArgumentNotValidException ex){
			
		BindingResult bindingResult = ex.getBindingResult();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
		
	}
			
}
