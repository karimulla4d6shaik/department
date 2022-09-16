package com.departments.app.dto;

public class DepartmentResponseDto {

	private String departmentCode;
	private String departmentName;
	private String departmentDesc;
	private String departmentLocation;

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

}
