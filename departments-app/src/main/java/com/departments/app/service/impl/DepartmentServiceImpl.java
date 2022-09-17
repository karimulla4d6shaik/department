package com.departments.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departments.app.constants.DepartmentConstant;
import com.departments.app.dto.DepartmentFinalResponseDto;
import com.departments.app.dto.DepartmentListDto;
import com.departments.app.dto.DepartmentRequestDto;
import com.departments.app.dto.DepartmentResponseDto;
import com.departments.app.dto.Notification;
import com.departments.app.entity.DepartmentEntity;
import com.departments.app.repo.DepartmentRepo;
import com.departments.app.service.DepartmentService;
import com.departments.app.util.DepartmentHelper;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private DepartmentHelper departmentHelper;

	@Override
	public DepartmentFinalResponseDto getDepartment(String departmentCode) {
		DepartmentEntity departmentEntity = departmentRepo.findByDepartmentCode(departmentCode);
		DepartmentResponseDto departmentResponseDto = departmentHelper
				.convertToTargetObject(departmentEntity, DepartmentResponseDto.class);	
		Notification notification = departmentHelper
		.buildNotification(DepartmentConstant.ONE_NOTIFICATION_SUCCESS_MESSAGE, 
				DepartmentConstant.ONE_NOTIFICATION_SUCCESS_STATUS, 
				DepartmentConstant.ONE_NOTIFICATION_SUCCESS_STATUS_CODE, DepartmentConstant.ONE_NOTIFICATION_SUCCESS_PATH);
		DepartmentFinalResponseDto finalResponseDto = new DepartmentFinalResponseDto();
		finalResponseDto.setDepartmentResponseDto(departmentResponseDto);
		finalResponseDto.setNotification(notification);
		return finalResponseDto;
	}

	@Override
	public DepartmentListDto getAllDepartment(String statusMessage, String path, String status, Integer statusCode) {		
		List<DepartmentEntity> departmentEntities = departmentRepo.findAll();
		List<DepartmentResponseDto> departmentResponseDtos = departmentEntities.stream()
		.map(de -> departmentHelper.convertToTargetObject(de, DepartmentResponseDto.class))
		.collect(Collectors.toList());
		if(statusMessage == null)
			statusMessage = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_MESSAGE;
		
		if(path == null)
			path = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_PATH;
		
		if(status == null)
			status = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_STATUS;
		
		if(statusCode == null) 
			statusCode = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_STATUS_CODE;
		
		Notification notification = departmentHelper.buildNotification(statusMessage, status, statusCode, path);
		DepartmentListDto departmentListDto = new DepartmentListDto();
		departmentListDto.setDepartmentResponseDtos(departmentResponseDtos);
		departmentListDto.setNotification(notification);
		return departmentListDto;
	}

	@Override
	public DepartmentListDto updateDepartment(DepartmentRequestDto departmentRequestDto) {
		DepartmentEntity departmentDetails = departmentRepo.findByDepartmentCode(departmentRequestDto.getDepartmentCode());
		if(departmentDetails != null) {
			departmentDetails.setDepartmentDesc(departmentRequestDto.getDepartmentDesc());
			departmentDetails.setDepartmentLocation(departmentRequestDto.getDepartmentLocation());
			departmentDetails.setDepartmentName(departmentRequestDto.getDepartmentName());
			departmentRepo.save(departmentDetails);
			return getAllDepartment(DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_MESSAGE, 
					DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_PATH, DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_STATUS,
					DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_STATUS_CODE);			
		}
		return null;
	}

	@Override
	public DepartmentListDto deleteDepartment(String departmentCode) {
		DepartmentEntity departmentDetails = departmentRepo.findByDepartmentCode(departmentCode);
		if(departmentDetails != null) {
			departmentRepo.delete(departmentDetails);			
			return getAllDepartment(DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_MESSAGE, 
					DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_PATH, 
					DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_STATUS,
					DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_STATUS_CODE);
		}
		return null;
	}

	@Override
	public DepartmentListDto addDepartment(DepartmentRequestDto departmentRequestDto) {
		DepartmentEntity departmentEntity = departmentHelper.convertToTargetObject(departmentRequestDto, DepartmentEntity.class);
		departmentRepo.save(departmentEntity);
		return getAllDepartment(DepartmentConstant.ADD_NOTIFICATION_SUCCESS_MESSAGE, 
				DepartmentConstant.ADD_NOTIFICATION_SUCCESS_PATH,
				DepartmentConstant.ADD_NOTIFICATION_SUCCESS_STATUS,
				DepartmentConstant.ADD_NOTIFICATION_SUCCESS_STATUS_CODE);
	}

	@Override
	public boolean findDepartmentByDeptCode(String departmentCode) {
		DepartmentEntity departmentEntity = departmentRepo.findByDepartmentCode(departmentCode);
		if(departmentEntity != null)
			return true;
		return false;
	}

}
