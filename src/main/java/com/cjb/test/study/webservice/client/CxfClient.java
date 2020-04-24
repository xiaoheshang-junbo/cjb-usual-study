/**
 * 
 */
package com.cjb.test.study.webservice.client;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.cjb.test.study.bean.token.QueryMpanStatusRequest;
import com.cjb.test.study.webservice.AppManageToStandardProvider;
import com.cjb.test.study.webservice.UserService;

/**
 * 客户端测试
 * @author junbo
 * 2019年5月13日 下午10:00:37
 */
public class CxfClient {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		testCli1();
//		testCli2();
		testCli4();
	}
	/**
	 * 测试1
	 * @throws Exception
	 */
	public static void testCli1() throws Exception {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf=JaxWsDynamicClientFactory.newInstance();
		Client client=dcf.createClient("http://127.0.0.1:8087/cjb-usual-study/webservice/user-api?wsdl");
		Object[] response=new Object[0];
		response=client.invoke("getUser", "1");
		System.out.println(response[0].toString());
	}
	/**
	 * 测试2
	 * 方式1.代理类工厂的方式,需要拿到对方的接口  -------适用与接口发布的服务
     *   接口代理类的发布
	 * @throws Exception
	 */
	public static void testCli2() throws Exception {
		//借口地址
		String address="http://127.0.0.1:8087/cjb-usual-study/webservice/user-api?wsdl";
		//代理工厂
		JaxWsProxyFactoryBean jpfb=new JaxWsProxyFactoryBean();
		//设置代理工厂地址
		jpfb.setAddress(address);
		//设置借口类型
		jpfb.setServiceClass(UserService.class);
		//创建一个代理借口实现
		UserService userService=(UserService) jpfb.create();
		//参数
		String id="1";
		//调用并返回结果
		Object res = userService.getUser(id);
		System.out.println(res);
	}
	/**
	 * 动态调用
	 * @throws Exception
	 */
	public static void testCli3() throws Exception{
		 // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8087/cjb-usual-study/webservice/user-api?wsdl");
        Object[] objects = new Object[]{};
        try {
            objects = client.invoke("getUser", "1");
            List<Object> objects1 = Arrays.asList(objects);
            System.out.println(objects1.get(0));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 测试2
	 * 方式1.代理类工厂的方式,需要拿到对方的接口  -------适用与接口发布的服务
     *   接口代理类的发布
	 * @throws Exception
	 */
	public static void testCli4() throws Exception {
		//借口地址
		String address="http://127.0.0.1:8087/cjb-usual-study/webservice/token";
		//代理工厂
		JaxWsProxyFactoryBean jpfb=new JaxWsProxyFactoryBean();
		//设置代理工厂地址
		jpfb.setAddress(address);
		//设置借口类型
		jpfb.setServiceClass(AppManageToStandardProvider.class);
		//创建一个代理借口实现
		AppManageToStandardProvider userService=(AppManageToStandardProvider) jpfb.create();
		//参数
		Holder<String> a=new Holder<String>("aaa");
		QueryMpanStatusRequest queryMpanStatusRequest=new QueryMpanStatusRequest();
		queryMpanStatusRequest.setSeId("aaaa".getBytes());
		queryMpanStatusRequest.setSpan("aaaa");;
		//调用并返回结果
		Object res = userService.queryMpanStatus(a, a, a, a, a, a, a, a, queryMpanStatusRequest);
		System.out.println(res);
	}
	
	
}
