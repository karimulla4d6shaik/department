package com.departments.app.dto;

import java.util.List;

public class DepartmentListDto {

	private List<DepartmentResponseDto> departmentResponseDtos;
	private Notification notification;

	public List<DepartmentResponseDto> getDepartmentResponseDtos() {
		return departmentResponseDtos;
	}

	public void setDepartmentResponseDtos(List<DepartmentResponseDto> departmentResponseDtos) {
		this.departmentResponseDtos = departmentResponseDtos;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}
