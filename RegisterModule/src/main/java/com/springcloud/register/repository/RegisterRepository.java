/**
 * 
 */
package com.springcloud.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.register.entity.User;

/**
 * @author 550769
 *
 */
public interface RegisterRepository extends JpaRepository<User, Long> {

	// Product findByProductCode(String productCode);
	User findByuserName(String userName);

}
