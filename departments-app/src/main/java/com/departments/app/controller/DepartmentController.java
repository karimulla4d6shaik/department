package com.departments.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departments.app.constants.PathConstant;
import com.departments.app.dto.DepartmentFinalResponseDto;
import com.departments.app.dto.DepartmentListDto;
import com.departments.app.dto.DepartmentRequestDto;
import com.departments.app.service.DepartmentService;

@RestController
@RequestMapping(PathConstant.DEPARTMENT_LEVEL_URL)
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<DepartmentListDto> getAllDepartments() {
		DepartmentListDto allDepartments = departmentService.getAllDepartment(null, null, null);		
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}
	
	@GetMapping(PathConstant.DEPARTMENT_CODE)
	public ResponseEntity<?> getDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentFinalResponseDto department = departmentService.getDepartment(departmentCode);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DepartmentListDto> addDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
		DepartmentListDto allDepartments = departmentService.addDepartment(departmentRequestDto);
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
		DepartmentListDto updateDepartment = departmentService.updateDepartment(departmentRequestDto);
		return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
	}
	
	@DeleteMapping(PathConstant.DEPARTMENT_CODE)
	public ResponseEntity<?> deleteDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentListDto deleteDepartment = departmentService.deleteDepartment(departmentCode);
		return new ResponseEntity<>(deleteDepartment, HttpStatus.OK);
	}
	
	@GetMapping(PathConstant.DEPARTMENT_CHECK)
	public ResponseEntity<Boolean> checkDepartentExistOrNot(@PathVariable("department-code") String departmentCode){
		return new ResponseEntity<>(departmentService.findDepartmentByDeptCode(departmentCode), HttpStatus.OK);
	}
}
