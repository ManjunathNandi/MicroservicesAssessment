/**
 * 
 */
package com.springcloud.register.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.register.Dao.RegisterDao;
import com.springcloud.register.entity.User;

/**
 * @author 550769
 *
 */
@Service("registerService")
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Transactional
	public void saveUser(User user) {
		registerDao.saveUser(user);
	}

	@Transactional
	public User getusers(String userName) {
		return registerDao.getusers(userName);
	}

}
