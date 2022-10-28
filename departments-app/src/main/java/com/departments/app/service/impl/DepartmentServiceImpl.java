package com.departments.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private DepartmentHelper departmentHelper;

	@Override
	public DepartmentFinalResponseDto getDepartment(String departmentCode) {
		LOGGER.info("Start of DepartmentServiceImpl class, getDepartment methood DEPARTMENT CODE - {}",departmentCode);
		DepartmentEntity departmentEntity = departmentRepo.findByDepartmentCode(departmentCode);
		DepartmentResponseDto departmentResponseDto = null;
		Notification notification = null;
		if(departmentEntity != null) {
			departmentResponseDto = departmentHelper
					.convertToTargetObject(departmentEntity, DepartmentResponseDto.class);	
			notification = departmentHelper
			.buildNotification(DepartmentConstant.ONE_NOTIFICATION_SUCCESS_MESSAGE+" "+departmentCode, 
					DepartmentConstant.ONE_NOTIFICATION_SUCCESS_STATUS, 
					DepartmentConstant.ONE_NOTIFICATION_SUCCESS_STATUS_CODE, "");
			
		}else {
			notification = departmentHelper
					.buildNotification(DepartmentConstant.NO_RECORDS_FOUND_MESSAGE+" "+departmentCode, 
							DepartmentConstant.NO_RECORDS_FOUND_STATUS, 
							DepartmentConstant.NO_RECORDS_FOUND_STATUS_CODE, "");
		}
		DepartmentFinalResponseDto finalResponseDto = new DepartmentFinalResponseDto();
		finalResponseDto.setDepartmentResponseDto(departmentResponseDto);
		finalResponseDto.setNotification(notification);
		LOGGER.info("End of DepartmentServiceImpl class, getDepartment methood DEPARTMENT FINAL RESPONSE DTO - {}",finalResponseDto);
		return finalResponseDto;
	}

	@Override
	public DepartmentListDto getAllDepartment(String statusMessage, String status, Integer statusCode) {
		LOGGER.info("Start of DepartmentServiceImpl class, getAllDepartment methood StatusMessage - {}, Status - {}, StatusCode - {}",statusMessage, status, statusCode);
		List<DepartmentEntity> departmentEntities = departmentRepo.findAll();
		List<DepartmentResponseDto> departmentResponseDtos = departmentEntities.stream()
		.map(de -> departmentHelper.convertToTargetObject(de, DepartmentResponseDto.class))
		.collect(Collectors.toList());
		
		if(departmentResponseDtos.isEmpty() && statusMessage == null && status == null && statusCode == null) {
			statusMessage = DepartmentConstant.NO_RECORDS_FOUND_MESSAGE;
			statusCode = DepartmentConstant.NO_RECORDS_FOUND_STATUS_CODE;
			status = DepartmentConstant.NO_RECORDS_FOUND_STATUS;
		}
			
		
		if(statusMessage == null)
			statusMessage = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_MESSAGE;
		
		
		if(status == null)
			status = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_STATUS;
		
		if(statusCode == null) 
			statusCode = DepartmentConstant.ALL_NOTIFICATION_SUCCESS_STATUS_CODE;
		
		Notification notification = departmentHelper.buildNotification(statusMessage, status, statusCode, "");
		DepartmentListDto departmentListDto = new DepartmentListDto();
		departmentListDto.setDepartmentResponseDtos(departmentResponseDtos);
		departmentListDto.setNotification(notification);
		LOGGER.info("End of DepartmentServiceImpl class, getAllDepartment methood DEPARTMENT LIST DTO - {}",departmentListDto);
		return departmentListDto;
	}

	@Override
	public DepartmentListDto updateDepartment(DepartmentRequestDto departmentRequestDto) {
		LOGGER.info("Start of DepartmentServiceImpl class, updateDepartment methood DEPARTMENT REQUEST DTO - {}",departmentRequestDto);
		DepartmentEntity departmentDetails = departmentRepo.findByDepartmentCode(departmentRequestDto.getDepartmentCode());
		if(departmentDetails != null) {
			departmentDetails.setDepartmentDesc(departmentRequestDto.getDepartmentDesc());
			departmentDetails.setDepartmentLocation(departmentRequestDto.getDepartmentLocation());
			departmentDetails.setDepartmentName(departmentRequestDto.getDepartmentName());
			departmentRepo.save(departmentDetails);
			LOGGER.info("End of DepartmentServiceImpl class, updateDepartment methood DEPARTMENT FOUND");
			return getAllDepartment(DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_MESSAGE, 
					DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_STATUS,
					DepartmentConstant.UPDATE_NOTIFICATION_SUCCESS_STATUS_CODE);			
		}
		LOGGER.info("End of DepartmentServiceImpl class, updateDepartment methood DEPARTMENT NOT FOUND");
		return null;
	}

	@Override
	public DepartmentListDto deleteDepartment(String departmentCode) {
		LOGGER.info("Start of DepartmentServiceImpl class, deleteDepartment methood DEPARTMENT CODE - {}",departmentCode);
		DepartmentEntity departmentDetails = departmentRepo.findByDepartmentCode(departmentCode);
		if(departmentDetails != null) {
			departmentRepo.delete(departmentDetails);
			LOGGER.info("End of DepartmentServiceImpl class, deleteDepartment methood DEPARTMENT CODE - {}, Found",departmentCode);
			return getAllDepartment(DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_MESSAGE, 
					DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_STATUS,
					DepartmentConstant.DELETE_NOTIFICATION_SUCCESS_STATUS_CODE);
		}
		LOGGER.info("End of DepartmentServiceImpl class, deleteDepartment methood DEPARTMENT CODE - {} Not Found",departmentCode);
		return null;
	}

	@Override
	public DepartmentListDto addDepartment(DepartmentRequestDto departmentRequestDto) {
		LOGGER.info("Start of DepartmentServiceImpl class, addDepartment methood DEPARTMENT DETAILS - {}",departmentRequestDto);
		DepartmentEntity departmentDetails = departmentRepo.findByDepartmentCode(departmentRequestDto.getDepartmentCode());
		DepartmentListDto allDepartment = null;
		if(departmentDetails == null) {
			DepartmentEntity departmentEntity = departmentHelper.convertToTargetObject(departmentRequestDto, DepartmentEntity.class);
			departmentRepo.save(departmentEntity);
			allDepartment = getAllDepartment(DepartmentConstant.ADD_NOTIFICATION_SUCCESS_MESSAGE, 
					DepartmentConstant.ADD_NOTIFICATION_SUCCESS_STATUS,
					DepartmentConstant.ADD_NOTIFICATION_SUCCESS_STATUS_CODE);
		}else {
			allDepartment = getAllDepartment(DepartmentConstant.DEPARTMENT_EXIST_MESSAGE, 
					DepartmentConstant.DEPARTMENT_EXIST_STATUS,
					DepartmentConstant.DEPARTMENT_EXIST_STATUS_CODE);
		}
		LOGGER.info("End of DepartmentServiceImpl class, addDepartment methood ALL DEPARTMENT DETAILS - {}",allDepartment);
		return allDepartment;
	}

	@Override
	public boolean findDepartmentByDeptCode(String departmentCode) {
		LOGGER.info("Start of DepartmentServiceImpl class, findDepartmentByDeptCode methood DEPARTMENT CODE - {}",departmentCode);
		DepartmentEntity departmentEntity = departmentRepo.findByDepartmentCode(departmentCode);
		if(departmentEntity != null) {
			LOGGER.info("End of DepartmentServiceImpl class, findDepartmentByDeptCode methood DEPARTMENT CODE - {}, Found",departmentCode);
			return true;
		}		
		LOGGER.info("End of DepartmentServiceImpl class, findDepartmentByDeptCode methood DEPARTMENT CODE - {}, Not Found",departmentCode);
		return false;
	}

}
