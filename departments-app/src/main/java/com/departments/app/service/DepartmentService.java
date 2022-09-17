package com.departments.app.service;

import com.departments.app.dto.DepartmentFinalResponseDto;
import com.departments.app.dto.DepartmentListDto;
import com.departments.app.dto.DepartmentRequestDto;

public interface DepartmentService {
	public DepartmentFinalResponseDto getDepartment(String departmentCode);	
	public DepartmentListDto getAllDepartment(String statusMessage, String status, Integer statusCode);	
	public DepartmentListDto updateDepartment(DepartmentRequestDto departmentRequestDto);
	public DepartmentListDto deleteDepartment(String departmentCode);
	public DepartmentListDto addDepartment(DepartmentRequestDto departmentRequestDto);	
	public boolean findDepartmentByDeptCode(String departmentCode);
}
