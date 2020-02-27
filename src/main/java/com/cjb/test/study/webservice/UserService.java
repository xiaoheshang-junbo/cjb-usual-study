/**
 * 
 */
package com.cjb.test.study.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 要发布的接口
 * @author junbo
 * 2019年5月13日 下午9:18:05
 */
@WebService(name = "userService", // 暴露服务名称
targetNamespace = "http://server.webservice.study.test.cjb.com"// 命名空间,一般是接口的包名倒序
)
public interface UserService {
	
	@WebMethod
	public String getUser(@WebParam(name="id") String id);
}
