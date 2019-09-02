/**
 * 
 */
package com.cjb.test.study.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSONObject;

/**
 * 统一异常处理类
 * @author junbo
 * 2019年9月2日 下午10:05:44
 */
@ControllerAdvice
public class ProcessControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public Object handle(Exception e) {
		JSONObject res=new JSONObject();
		res.put("msg",e.getMessage());
		return res;
	}

}
