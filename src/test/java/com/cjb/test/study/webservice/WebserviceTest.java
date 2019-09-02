/**
 * 
 */
package com.cjb.test.study.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjb.test.study.webservice.sever.UserService;

/**
 * 
 * @author junbo
 * 2019年9月2日 下午10:30:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebserviceTest {
	@Autowired
	UserService userService;
	
	@Test
	public void getUser() {
		userService.getUser("a");
	}

}
