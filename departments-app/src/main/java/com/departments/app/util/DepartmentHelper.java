package com.departments.app.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentHelper {
	@Autowired
	private ModelMapper mapper;
	
	public <T> T convertToTargetObject(Object obj, Class<T> targetClass){
		return mapper.map(obj, targetClass);
	}
}
