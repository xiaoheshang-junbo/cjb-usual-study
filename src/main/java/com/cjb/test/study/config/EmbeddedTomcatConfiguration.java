/**
 * 
 */
package com.cjb.test.study.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 配置多个端口监听 springboot2之前的写法
 * @author MyPC
 * 2019年4月21日 下午1:47:43
 */
@Configuration
public class EmbeddedTomcatConfiguration implements EmbeddedServletContainerCustomizer{
	@Value("${my.port1}")
	private int port1;
	@Value("${my.port2}")
	private int port2;
	

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		//判断如果是tomcat才进行配置
		if(container instanceof TomcatEmbeddedServletContainerFactory) {
			TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory)container;
			List<Connector> result=new ArrayList<Connector>();
			Connector httpConnector1=new Connector("HTTP/1.1");
			httpConnector1.setPort(port1);
			result.add(httpConnector1);
			Connector httpConnector2=new Connector("HTTP/1.1");
			httpConnector2.setPort(port2);
			result.add(httpConnector2);
			tomcat.addAdditionalTomcatConnectors(result.toArray(new Connector[]{}));
		}
		
	}
	
	


}
