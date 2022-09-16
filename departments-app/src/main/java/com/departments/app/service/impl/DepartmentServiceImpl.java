package com.departments.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departments.app.dto.DepartmentRequestDto;
import com.departments.app.dto.DepartmentResponseDto;
import com.departments.app.entity.DepartmentEntity;
import com.departments.app.repo.DepartmentRepo;
import com.departments.app.service.DepartmentService;
import com.departments.app.util.DepartmentHelper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private DepartmentHelper departmentHelper;

	@Override
	public Mono<DepartmentResponseDto> getDepartment(String departmentCode) {
		DepartmentEntity departmentEntity = departmentRepo.findByDepartmentCode(departmentCode);
		DepartmentResponseDto departmentResponseDto = departmentHelper
				.convertToTargetObject(departmentEntity, DepartmentResponseDto.class);		
		Mono<DepartmentResponseDto> monoDepartmentResponseDto = Mono.just(departmentResponseDto);
		return monoDepartmentResponseDto;
	}

	@Override
	public Flux<DepartmentResponseDto> getAllDepartment() {
		return null;
	}

	@Override
	public Mono<DepartmentResponseDto> updateDepartment(DepartmentRequestDto departmentRequestDto) {
		return null;
	}

	@Override
	public Mono<DepartmentResponseDto> deleteDepartment(String departmentCode) {
		return null;
	}

	@Override
	public Mono<DepartmentResponseDto> addDepartment(DepartmentRequestDto departmentRequestDto) {
		return null;
	}

}
