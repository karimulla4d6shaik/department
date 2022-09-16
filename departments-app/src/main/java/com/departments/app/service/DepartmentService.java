package com.departments.app.service;

import com.departments.app.dto.DepartmentRequestDto;
import com.departments.app.dto.DepartmentResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepartmentService {
	public Mono<DepartmentResponseDto> getDepartment(String departmentCode);	
	public Flux<DepartmentResponseDto> getAllDepartment();	
	public Mono<DepartmentResponseDto> updateDepartment(DepartmentRequestDto departmentRequestDto);
	public Mono<DepartmentResponseDto> deleteDepartment(String departmentCode);
	public Mono<DepartmentResponseDto> addDepartment(DepartmentRequestDto departmentRequestDto);	
}
