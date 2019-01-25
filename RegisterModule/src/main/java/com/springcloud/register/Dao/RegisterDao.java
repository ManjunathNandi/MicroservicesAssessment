/**
 * 
 */
package com.springcloud.register.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcloud.register.entity.User;
import com.springcloud.register.repository.RegisterRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 550769
 *
 */
@Repository("registerDao")
@Slf4j
public class RegisterDao {

	@Autowired
	private RegisterRepository registerRepository;

	public void saveUser(User user) {

		registerRepository.save(user);

	}

	public User getusers(String userName) {

		return registerRepository.findByuserName(userName);

		/*
		 * User users = registerRepository.findByuserName(userName); return
		 * users; User users =
		 * registerRepository.findByuserName(user.getUserName());
		 * System.out.println("users "+ users.getEmail());
		 * System.out.println("users "+ users.getPassWord());
		 * System.out.println("users "+ users.getRepeatPassword());
		 * System.out.println("users "+ users.getUserName());
		 */

	}

}
