/**
 * 
 */
package com.springcloud.login.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.login.entity.UserData;
import com.springcloud.login.service.LoginService;


/**
 * @author 550769
 *
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/welcome")
	public String returnWelcome(){
		System.out.println("==========================================");
		return"welcome";
	}
	
	
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	public String getusers(@RequestBody UserData user) {
		System.out.println(user.getUserName());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$");
		return loginService.getusers(user.getUserName());
		 
	
	}

}
