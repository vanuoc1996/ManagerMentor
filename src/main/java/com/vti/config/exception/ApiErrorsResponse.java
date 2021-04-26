/**
 * @author: LQHuy
 * @create_date: Mar 8, 2021
 * @TODO
 * @ApiErrorsResponse
 */
package com.vti.config.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 *
 */
public class ApiErrorsResponse {
	private HttpStatus status;

	private String message;

	private List<String> detailMessage;

	public ApiErrorsResponse(HttpStatus status, String message, List<String> detailMessage) {
		this.status = status;
		this.message = message;
		this.detailMessage = detailMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(List<String> detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	

}
