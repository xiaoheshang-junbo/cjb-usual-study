/**
 * 
 */
package com.cjb.test.study.webservice.sever;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CXF配置类发布webserver服务
 * @author junbo
 * 2019年5月13日 下午9:30:43
 */
@Configuration
public class CxfConfig {
	@Autowired
	private Bus bus;
	@Autowired
	private UserService userService;
	/**
	 * cxf分发指定目录 默认servlet路径/*,如果覆写则按照自己定义的来
	 * @return
	 */
	@Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");
    }

	/**
	 * jax-ws
	 * @return
	 */
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endPoint=new EndpointImpl(bus,userService);
		endPoint.publish("/user-api");
		return endPoint;
	}
	
	public Endpoint endpoint1() {
		return null;
	}
}
