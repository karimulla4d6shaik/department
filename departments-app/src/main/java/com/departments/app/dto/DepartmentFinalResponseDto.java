package com.departments.app.dto;

public class DepartmentFinalResponseDto {

	private Notification notification;
	private DepartmentResponseDto departmentResponseDto;

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public DepartmentResponseDto getDepartmentResponseDto() {
		return departmentResponseDto;
	}

	public void setDepartmentResponseDto(DepartmentResponseDto departmentResponseDto) {
		this.departmentResponseDto = departmentResponseDto;
	}

	@Override
	public String toString() {
		return "DepartmentFinalResponseDto [notification=" + notification + ", departmentResponseDto="
				+ departmentResponseDto + "]";
	}
	
	

}
