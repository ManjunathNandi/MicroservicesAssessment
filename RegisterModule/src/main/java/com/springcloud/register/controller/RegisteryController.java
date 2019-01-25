/**
 * 
 */
package com.springcloud.register.controller;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.register.entity.User;
import com.springcloud.register.entity.UserData;
import com.springcloud.register.service.RegisterService;

/**
 * @author 550769
 *
 */
@RestController
@RequestMapping("/api/register")
public class RegisteryController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping("/welcome")
	public String returnWelcome() {
		//System.out.println("==========================================");
		return "welcome";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		System.out.println("==========================================");
		registerService.saveUser(user);

		System.out.println("Creating User " +user.getUserName()) ;
		/*
		 * if(userService.isUserExist(user)){
		 * System.out.println("A User with name "+user.getName()
		 * +" already exist"); return new
		 * ResponseEntity<Void>(HttpStatus.CONFLICT); }
		 */

		return "You Are registered Sucessfully";
	}
	
	@RequestMapping(value="/get/{name}", method=RequestMethod.GET)
	
	public User getusers(@PathVariable String name) {
		
		return registerService.getusers(name);
		  
	
	}
	
}
