package com.departments.app.constants;

public interface PathConstant {

	public static final String DEPARTMENT_LEVEL_URL = "/v1/department";
	public static final String DEPARTMENT_CODE = "/{department-code}";
	public static final String DEPARTMENT_CHECK = "/check/{department-code}";
	public static final String GET_DEPARTMENT_BY_DEPT_CODE = DEPARTMENT_LEVEL_URL+DEPARTMENT_CODE;
	public static final String UPDATE_DEPARTMENT = DEPARTMENT_LEVEL_URL;
	public static final String ADD_DEPARTMENT = DEPARTMENT_LEVEL_URL;
	public static final String DELETE_DEPARTMENT_BY_DEPT_CODE = DEPARTMENT_LEVEL_URL+DEPARTMENT_CODE;
}
