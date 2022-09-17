package com.departments.app.util;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departments.app.dto.Notification;

@Service
public class DepartmentHelper {
	@Autowired
	private ModelMapper mapper;
	
	public <T> T convertToTargetObject(Object obj, Class<T> targetClass){
		return mapper.map(obj, targetClass);
	}
	
	public Notification buildNotification(String message, String status, Integer statusCode, String path) {
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setStatus(status);
		notification.setStatusCode(statusCode);
		notification.setPath(path);
		notification.setTime(LocalTime.now());
		return notification;
	}
}
