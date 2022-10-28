package com.departments.app.util;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departments.app.dto.Notification;

@Service
public class DepartmentHelper {
	
	private Logger LOGGER = LoggerFactory.getLogger(DepartmentHelper.class);
	@Autowired
	private ModelMapper mapper;
	
	public <T> T convertToTargetObject(Object obj, Class<T> targetClass){
		LOGGER.info("DepartmentHelper class, convertToTargetObject method");
		return mapper.map(obj, targetClass);
	}
	
	public Notification buildNotification(String message, String status, Integer statusCode, String path) {
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setStatus(status);
		notification.setStatusCode(statusCode);
		notification.setPath(path);
		notification.setTime(LocalTime.now());
		LOGGER.info("DepartmentHelper class, buildNotification method NOTIFICATION Value - {}",notification);
		return notification;
	}
}
