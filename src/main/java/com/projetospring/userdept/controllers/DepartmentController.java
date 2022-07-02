package com.projetospring.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.userdept.entities.Department;
import com.projetospring.userdept.repositories.DepartmentRepository;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentRepository repository;
	
	@GetMapping
	public List<Department> getAll(){
		List<Department> listDepartments = repository.findAll();
		return listDepartments;
	}
	
	@GetMapping(value = "/{id}")
	public Department getId(@PathVariable Long id) {
		Department departmentId = repository.findById(id).get();
		return departmentId;
	}
	
	@PostMapping
	public Department insertDepartment(@RequestBody Department department) {
		Department departmentInsert = repository.save(department);
		return departmentInsert;
		
	}
}
