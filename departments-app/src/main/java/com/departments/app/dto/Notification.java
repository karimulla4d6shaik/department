package com.departments.app.dto;

import java.time.LocalTime;

public class Notification {

	private String status;
	private Integer statusCode;
	private String message;
	private String path;
	private LocalTime time;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Notification [status=" + status + ", statusCode=" + statusCode + ", message=" + message + ", path="
				+ path + ", time=" + time + "]";
	}

}
