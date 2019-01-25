/**
 * 
 */
package com.springcloud.login.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.login.dao.LoginDao;

/**
 * @author 550769
 *
 */
@Service("loginService")
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	@Transactional
	public String getusers(String userName) {
		return loginDao.getUserName(userName);
	}

}
