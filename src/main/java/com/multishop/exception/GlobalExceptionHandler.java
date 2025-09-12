package com.multishop.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.multishop.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errors);
	}

	// Bắt lỗi validate (DTO)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationExceptions(
			MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		ApiResponse<Map<String, String>> response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(),
				"Validation failed", errors);

		return ResponseEntity.badRequest().body(response);
	}

	// Bắt các Exception chung
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> handleGlobalException(Exception ex) {
		ApiResponse<String> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(),
				null);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
