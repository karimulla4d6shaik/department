package com.departments.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<DepartmentListDto> getAllDepartments() {
		LOGGER.info("Start of DepartmentController class, getAllDepartments method");
		DepartmentListDto allDepartments = departmentService.getAllDepartment(null, null, null);
		LOGGER.info("End of DepartmentController class, getAllDepartments method");
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}
	
	@GetMapping(PathConstant.DEPARTMENT_CODE)
	public ResponseEntity<?> getDepartment(@PathVariable("department-code") String departmentCode){
		LOGGER.info("Start of DepartmentController class, getDepartment method DEPARTMENT CODDE - {}",departmentCode);
		DepartmentFinalResponseDto department = departmentService.getDepartment(departmentCode);
		LOGGER.info("End of DepartmentController class, getDepartment method DEPARTMENT CODDE - {}",departmentCode);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DepartmentListDto> addDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
		LOGGER.info("Start of DepartmentController class, addDepartment method DEPARTMENT CODDE - {}", departmentRequestDto.getDepartmentCode());
		DepartmentListDto allDepartments = departmentService.addDepartment(departmentRequestDto);
		LOGGER.info("End of DepartmentController class, addDepartment method DEPARTMENT CODDE - {}", departmentRequestDto.getDepartmentCode());
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
		LOGGER.info("Start of DepartmentController class, updateDepartment method DEPARTMENT CODDE - {}",departmentRequestDto.getDepartmentCode());
		DepartmentListDto updateDepartment = departmentService.updateDepartment(departmentRequestDto);
		LOGGER.info("End of DepartmentController class, updateDepartment method DEPARTMENT CODDE - {}",departmentRequestDto.getDepartmentCode());
		return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
	}
	
	@DeleteMapping(PathConstant.DEPARTMENT_CODE)
	public ResponseEntity<?> deleteDepartment(@PathVariable("department-code") String departmentCode){
		LOGGER.info("Start of DepartmentController class, deleteDepartment method DEPARTMENT CODDE - {}",departmentCode);
		DepartmentListDto deleteDepartment = departmentService.deleteDepartment(departmentCode);
		LOGGER.info("Start of DepartmentController class, deleteDepartment method DEPARTMENT CODDE - {}",departmentCode);
		return new ResponseEntity<>(deleteDepartment, HttpStatus.OK);
	}
	
	@GetMapping(PathConstant.DEPARTMENT_CHECK)
	public ResponseEntity<Boolean> checkDepartentExistOrNot(@PathVariable("department-code") String departmentCode){
		LOGGER.info("Start and End of DepartmentController class, checkDepartentExistOrNot method DEPARTMENT CODDE - {}",departmentCode);
		return new ResponseEntity<>(departmentService.findDepartmentByDeptCode(departmentCode), HttpStatus.OK);
	}
}
