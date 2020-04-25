/**
 * 
 */
package com.cjb.test.study.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cjb.test.study.webservice.GlobalEligibilityInfo;
import com.cjb.test.study.webservice.UserService;
import com.cjb.test.study.webservice.sever.AppManageToStandardProviderImpl;

/**
 * CXF配置类发布webserver服务
 * 
 * @author junbo
 * 2019年5月13日 下午9:30:43
 */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private UserService userService;
    @Autowired
    private GlobalEligibilityInfo globalEligibilityInfo;

    /**
     * cxf分发指定目录 默认servlet路径/*,如果覆写则按照自己定义的来
     * 
     * @return
     */
    // @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/*");
    }

    /**
     * jax-ws
     * 
     * @return
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endPoint = new EndpointImpl(bus, userService);
        endPoint.publish("/user-api");
        return endPoint;
    }

    /**
     * jax-ws
     * 
     * @return
     */
    @Bean
    public Endpoint endpointToken() {
        EndpointImpl endPoint = new EndpointImpl(bus, new AppManageToStandardProviderImpl());
        endPoint.publish("/token");
        return endPoint;
    }

    /**
     * jax-ws
     * 
     * @return
     */
    @Bean
    public Endpoint endpointHce() {
        EndpointImpl endPoint = new EndpointImpl(bus, globalEligibilityInfo);
        // soap1.2 CXF默认没有打开ws-addressing开关 会出现are not understood的问题
        // http://cxf.apache.org/docs/ws-addressing.html
        endPoint.getFeatures().add(new WSAddressingFeature());
        endPoint.publish("/hce");
        return endPoint;
    }
}
