/**
 * @author: LQHuy
 * @create_date: Mar 8, 2021
 * @TODO
 * @RestExceptionHandler
 */
package com.vti.config.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Administrator
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 * this method to handle MethodArgumentNotValidException
	 * 
	 * @param exception
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 8, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 8, 2021
	 *
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		List<ObjectError> objectErrors = exception.getAllErrors();

		for (ObjectError objectError : objectErrors) {
			errors.add(objectError.getDefaultMessage());
		}

		ApiErrorsResponse error = new ApiErrorsResponse(HttpStatus.BAD_REQUEST,
				"Dữ liệu của bạn chưa chính xác, mời bạn xem lại", errors);

		return new ResponseEntity<>(error, error.getStatus());
	}

	/**
	 * 
	 * this method to handle HttpMessageNotReadableException
	 * 
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 8, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 8, 2021
	 *
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Dữ liệu không chính xác, hãy kiểm tra lại", ex.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	/**
	 * 
	 * this method to handle ConstraintViolationException
	 * 
	 * @param exception
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 8, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 8, 2021
	 * @return: ResponseEntity<?>
	 *
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> HandleConstraintViolation(ConstraintViolationException exception) {

		List<String> errors = new ArrayList<String>();
		Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			errors.add(constraintViolation.getMessage());
		}

		ApiErrorsResponse error = new ApiErrorsResponse(HttpStatus.BAD_REQUEST,
				"Dữ liệu của bạn chưa chính xác, mời bạn xem lại", errors);
		return new ResponseEntity<>(error, error.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HandleException(Exception exception) {

		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Dữ liệu của bạn chưa chính xác, mời bạn xem lại", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

}
