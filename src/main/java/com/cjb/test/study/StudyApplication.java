/**
 * 
 */
package com.cjb.test.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author MyPC
 * 2019年4月20日 下午11:54:19
 */
@SpringBootApplication
@ComponentScan(value = "com.cjb.test.study")
public class StudyApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
