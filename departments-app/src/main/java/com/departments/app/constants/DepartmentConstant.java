package com.departments.app.constants;

import org.springframework.http.HttpStatus;

public interface DepartmentConstant {
	
	public static final String NO_RECORDS_FOUND_MESSAGE = "No data found for department...";
	public static final String NO_RECORDS_FOUND_STATUS = HttpStatus.NOT_FOUND.getReasonPhrase();
	public static final Integer NO_RECORDS_FOUND_STATUS_CODE = HttpStatus.NOT_FOUND.value();
	
	public static final String ALL_NOTIFICATION_SUCCESS_MESSAGE = "Retrived all department successfully...";
	public static final String ALL_NOTIFICATION_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();	
	public static final Integer ALL_NOTIFICATION_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	
	public static final String ONE_NOTIFICATION_SUCCESS_MESSAGE = "Department retrived successfully...";
	public static final String ONE_NOTIFICATION_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();	
	public static final Integer ONE_NOTIFICATION_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	
	
	public static final String UPDATE_NOTIFICATION_SUCCESS_MESSAGE = "Department updated successfully...";
	public static final String UPDATE_NOTIFICATION_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer UPDATE_NOTIFICATION_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	
	public static final String DELETE_NOTIFICATION_SUCCESS_MESSAGE = "Department deleted successfully...";
	public static final String DELETE_NOTIFICATION_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer DELETE_NOTIFICATION_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	
	public static final String ADD_NOTIFICATION_SUCCESS_MESSAGE = "Department added successfully...";
	public static final String ADD_NOTIFICATION_SUCCESS_STATUS = HttpStatus.CREATED.getReasonPhrase();	
	public static final Integer ADD_NOTIFICATION_SUCCESS_STATUS_CODE = HttpStatus.CREATED.value();
}
