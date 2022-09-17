package com.departments.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT_TBL")
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPT_ID")
	private Integer departmentId;
	@Column(name = "DEPT_CODE", unique = true, nullable = false)
	private String departmentCode;
	@Column(name = "DEPT_NAME", nullable = false)
	private String departmentName;
	@Column(name = "DEPT_DESC", nullable = false)
	private String departmentDesc;
	@Column(name = "DEPT_LOC", nullable = false)
	private String departmentLocation;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

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
