package com.projetospring.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.userdept.entities.User;
import com.projetospring.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")

public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> getAll(){
		List<User> listUser = repository.findAll();
		return listUser;
		
	}

	@GetMapping(value = "/{id}")
	public User getId(@PathVariable Long id) {
		User userId = repository.findById(id).get();
		return userId;
	}
	
	@PostMapping
	public User insertUser(@RequestBody User user) {
		User userInsert = repository.save(user);
		return userInsert;
	}

}
