package com.multishop.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

	private int status;
	private String message;
	private T data;
	private LocalDateTime timestamp;

	public ApiResponse(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

}