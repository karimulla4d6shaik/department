package com.departments.app.dto;

import javax.validation.constraints.NotEmpty;

public class DepartmentRequestDto {

	@NotEmpty(message = "Department code must not empty or null")
	private String departmentCode;
	@NotEmpty(message = "Department name must not empty or null")
	private String departmentName;
	@NotEmpty(message = "Department description must not empty or null")
	private String departmentDesc;
	@NotEmpty(message = "Department location must not empty or null")
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

	@Override
	public String toString() {
		return "DepartmentRequestDto [departmentCode=" + departmentCode + ", departmentName=" + departmentName
				+ ", departmentDesc=" + departmentDesc + ", departmentLocation=" + departmentLocation + "]";
	}

}
