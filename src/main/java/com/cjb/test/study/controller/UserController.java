/**
 * 
 */
package com.cjb.test.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cjb.test.study.bean.User;

/**
 * 控制器
 * @author MyPC
 * 2019年4月21日 下午2:14:24
 */
@RestController
public class UserController {

	@GetMapping(value = "/user/{id}")
	public User getUser(@PathVariable String id) {
		
		return new User(id); 
	}
}
