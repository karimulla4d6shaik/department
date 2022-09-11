package com.departments.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/department")
public class DepartmentController {

	@GetMapping
	public ResponseEntity<?> getAllDepartments() {
		return null;
	}
	
	@GetMapping("/{department-id}")
	public ResponseEntity<?> getDepartment(@PathVariable("department-id") Integer departmentId){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> addDepartment(){
		return null;
	}
	
	@PutMapping("/{department-id}")
	public ResponseEntity<?> updateDepartment(@PathVariable("department-id") Integer departmentId){
		return null;
	}
	
	@DeleteMapping("/{department-id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("department-id") Integer departmentId){
		return null;
	}
}
