package com.jsp.warehouse.exceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.utility.ErrorStructure;
import com.jsp.warehouse.utility.ResponseStructure;

@RestControllerAdvice
public class ExceptionHadler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> IllegalOperationException(com.jsp.warehouse.exception.IllegalOperationException exception){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
				new ErrorStructure<String>()
				.setMessage("illgeal operetions")
				.setRootCause(exception.getMessage())
			.setStatus(HttpStatus.FORBIDDEN.value()));
		
	}		
		
		@ExceptionHandler
		public ResponseEntity<ErrorStructure<Map<String, String>>> IllegalOperationExceptionMethod(MethodArgumentNotValidException ex){
			  List<ObjectError> errors = ex.getAllErrors();
			  
			  
			  Map<String , String > allErrors = new HashMap<String, String>();
			  
			  
			   errors.forEach(error->{
				   FieldError fieldError = (FieldError) error;
				   String field = fieldError.getField();
				   String message = fieldError.getDefaultMessage();
				   allErrors.put(field, message);
				   
				   
			   });
			   
			   return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(new ErrorStructure<Map<String,String>>()
								.setStatus(HttpStatus.BAD_REQUEST.value())
								.setMessage("Invalid input")
								.setRootCause(allErrors));
		
			  
			  
		}
		
//		@ExceptionHandler
//		public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(IllegalOperationException ex){
//			return errorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), 
//					"The user is not found by the given Id");
//		}
//		
//	}
		
		
		@ExceptionHandler
		public ResponseEntity<ErrorStructure<String>>  UsernameNotFoundException(UsernameNotFoundException exception){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ErrorStructure<String>()
					.setMessage("not found")
					.setRootCause(exception.getMessage())
				.setStatus(HttpStatus.NOT_FOUND.value()));
			
		}	

}
