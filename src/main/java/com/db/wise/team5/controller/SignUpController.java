package com.db.wise.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.wise.team5.model.User;
import com.db.wise.team5.repository.SignUpDAO;

@RestController
public class SignUpController {
	
	@Autowired
	SignUpDAO singupDAO;	
	
	@PostMapping("/singup")
	public boolean createUser(@RequestBody User user) {
		return singupDAO.createUserInDatabase(user); 
	}

}
