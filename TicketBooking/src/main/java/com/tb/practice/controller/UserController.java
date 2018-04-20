package com.tb.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tb.practice.entity.Event;
import com.tb.practice.entity.Users;
import com.tb.practice.repository.UserRepository;
import com.tb.practice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/allUsers")
	public List<Users> getAllUsers(){
		
		return userService.allUsers();
	}

	@GetMapping("/user/id/{id}")
	public Users findUser(@PathVariable("id") int id){
		
		return userService.findUser(id);
	}
	
	@GetMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable("id") int id){
		
		userService.deletUser(id);
		
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Users saveUser(@RequestBody Users user){
		
		return userService.createUser(user);
		
	}
}
