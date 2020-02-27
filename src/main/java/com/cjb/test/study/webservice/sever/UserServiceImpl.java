/**
 * 
 */
package com.cjb.test.study.webservice.sever;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cjb.test.study.bean.User;
import com.cjb.test.study.webservice.UserService;

/**
 * 要发布的实现类
 * @author junbo
 * 2019年5月13日 下午9:22:18
 */
//name暴露的服务名称, targetNamespace:命名空间,设置为接口的包名倒写(默认是本类包名倒写). endpointInterface接口地址
@WebService(name = "userService",//暴露服务名称，与接口中指定的name一致
targetNamespace = "http://server.webservice.study.test.cjb.com",//与接口中的命名空间一致,一般是接口的包名倒
endpointInterface = "com.cjb.test.study.webservice.UserService"// 接口地址
)
@Component
public class UserServiceImpl implements UserService {
	private Logger log=LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public String getUser(String id) {
		log.info("id=="+id);
		return new User(id).toString();
	}

}
