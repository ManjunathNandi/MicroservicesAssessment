/**
 * 
 */
package com.springcloud.login.dao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.springcloud.login.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 550769
 *
 */
@Repository("loginDao")
@Slf4j
public class LoginDao {

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@HystrixCommand(fallbackMethod="fallback_getProductByCode", commandProperties= {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3500"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60")
	})
	public String getUserName(String userName) {
		try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		String url = "http://registery-service/api/register/get/"+userName; //http://localhost:9995/api/register/get
		System.out.println(("URLLL&&&&&&& " + url.toString()));
		ResponseEntity<User> responseProduct = restTemplate.getForEntity(url, User.class);
		//log.info("Response Product: " + responseProduct.toString());
		System.out.println(("Response Product: " + responseProduct.toString()));
		if(responseProduct.getStatusCode() == HttpStatus.OK) {
			
			if(responseProduct.getBody().getUserName().equalsIgnoreCase(userName)) {
				System.out.println("+" +responseProduct.getBody().getUserName());
				System.out.println("+" +responseProduct.getBody().getPassWord());
				System.out.println("+" +responseProduct.getBody().getRepeatPassword());
				System.out.println("+" +responseProduct.getBody().getEmail());

				
				return "sucessfull";
			}else {
				return "NOt aaaaaa sucessfull";
				//System.out.println("not sucessfull.");
			}
		}else {
			//log.error("Not able to get response for " + userName);
			//log.error("Error Status Code: " + responseProduct.getStatusCodeValue());
		}
		return "sucessccccc&&&&&&&&";
		
	
	}
	
	String fallback_getProductByCode(String code) {
		//log.info("Fall back method in action for getProductByCode for :" + code);
		/*Product pr = new Product();
		pr.setProductCode(code);
		pr.setName("Not Found");
		pr.setStockStatus(false);
		pr.setDescription("Not Found");
		pr.setPrice(0);
		
		return pr;*/
		
		return" Yes i am truely sucvess)(*)((*)*)()(**)()(*)(*";
	}
	
}
