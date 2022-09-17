package com.departments.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departments.app.entity.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer>{

	public DepartmentEntity findByDepartmentCode(String departmentCode);
}
