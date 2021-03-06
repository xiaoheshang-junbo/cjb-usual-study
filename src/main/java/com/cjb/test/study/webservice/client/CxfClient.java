/**
 * 
 */
package com.cjb.test.study.webservice.client;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.ws.addressing.WSAddressingFeature;

import com.alibaba.fastjson.JSON;
import com.cjb.test.study.bean.hce.ApplyInfoType;
import com.cjb.test.study.bean.hce.CheckGlobalEligibilityRequestType;
import com.cjb.test.study.bean.hce.DeployServiceResponseType;
import com.cjb.test.study.bean.hce.ExtensionsType;
import com.cjb.test.study.bean.hce.HceCardInfoType;
import com.cjb.test.study.bean.hce.ObjectFactory;
import com.cjb.test.study.bean.hce.SEIdGenericType;
import com.cjb.test.study.bean.hce.ServiceIdentifierType;
import com.cjb.test.study.bean.token.MpanApplyRequest;
import com.cjb.test.study.bean.token.QueryMpanStatusRequest;
import com.cjb.test.study.webservice.AppManageToStandardProvider;
import com.cjb.test.study.webservice.GlobalEligibilityInfo;
import com.cjb.test.study.webservice.UserService;

/**
 * 客户端测试
 * 
 * @author junbo
 * 2019年5月13日 下午10:00:37
 */
public class CxfClient {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // testCli1();
        // testCli2();
        // testCli4();
        // testCli5();
        testCli6();
    }

    /**
     * 测试1
     * 
     * @throws Exception
     */
    public static void testCli1() throws Exception {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8087/cjb-usual-study/webservice/user-api?wsdl");
        Object[] response = new Object[0];
        response = client.invoke("getUser", "1");
        System.out.println(response[0].toString());
    }

    /**
     * 测试2
     * 方式1.代理类工厂的方式,需要拿到对方的接口 -------适用与接口发布的服务
     * 接口代理类的发布
     * 
     * @throws Exception
     */
    public static void testCli2() throws Exception {
        // 借口地址
        String address = "http://127.0.0.1:8087/cjb-usual-study/webservice/user-api?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean jpfb = new JaxWsProxyFactoryBean();
        // 设置代理工厂地址
        jpfb.setAddress(address);
        // 设置借口类型
        jpfb.setServiceClass(UserService.class);
        // 创建一个代理借口实现
        UserService userService = (UserService) jpfb.create();
        // 参数
        String id = "1";
        // 调用并返回结果
        Object res = userService.getUser(id);
        System.out.println(JSON.toJSONString(res));
    }

    /**
     * 动态调用
     * 
     * @throws Exception
     */
    public static void testCli3() throws Exception {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8087/cjb-usual-study/webservice/user-api?wsdl");
        Object[] objects = new Object[] {};
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
     * 方式1.代理类工厂的方式,需要拿到对方的接口 -------适用与接口发布的服务
     * 接口代理类的发布
     * 
     * @throws Exception
     */
    public static void testCli4() throws Exception {
        // 借口地址
        String address = "http://127.0.0.1:8087/cjb-usual-study/token";
        // 代理工厂
        JaxWsProxyFactoryBean jpfb = new JaxWsProxyFactoryBean();
        // 设置代理工厂地址
        jpfb.setAddress(address);
        // 设置借口类型
        jpfb.setServiceClass(AppManageToStandardProvider.class);
        // 创建一个代理借口实现
        AppManageToStandardProvider userService = (AppManageToStandardProvider) jpfb.create();
        // 参数
        Holder<String> a = new Holder<String>("aaa");
        QueryMpanStatusRequest queryMpanStatusRequest = new QueryMpanStatusRequest();
        queryMpanStatusRequest.setSeId("aaaa".getBytes());
        queryMpanStatusRequest.setSpan("aaaa");

        MpanApplyRequest mpanApplyReq = new MpanApplyRequest();
        mpanApplyReq.setSeType("dgad");

        // 调用并返回结果
        Object res = userService.mpanApply(a, a, a, a, a, a, a, a, mpanApplyReq);
        System.out.println(JSON.toJSONString(res));
    }

    /**
     * 测试5
     * 方式1.代理类工厂的方式,需要拿到对方的接口 -------适用与接口发布的服务
     * 接口代理类的发布
     * 
     * @throws Exception
     */
    public static void testCli5() throws Exception {
        // 借口地址
        String address = "http://127.0.0.1:8087/cjb-usual-study/hce";
        // 代理工厂
        JaxWsProxyFactoryBean jpfb = new JaxWsProxyFactoryBean();
        // 设置代理工厂地址
        jpfb.setAddress(address);
        // 设置借口类型
        jpfb.setServiceClass(GlobalEligibilityInfo.class);
        // 创建一个代理借口实现
        GlobalEligibilityInfo userService = (GlobalEligibilityInfo) jpfb.create();
        // 参数
        CheckGlobalEligibilityRequestType checkGlobalEligibilityRequest = new CheckGlobalEligibilityRequestType();
        checkGlobalEligibilityRequest.setFunctionCallIdentifier("FunctionCallIdentifier");
        checkGlobalEligibilityRequest.setValidityPeriod(new BigInteger("1"));
        SEIdGenericType seid = new SEIdGenericType();
        seid.setId("seid");
        seid.setType("seidType");
        checkGlobalEligibilityRequest.setSecureElement(seid);
        ServiceIdentifierType ser = new ServiceIdentifierType();
        ser.setServiceId(new BigInteger("1"));
        checkGlobalEligibilityRequest.setService(ser);
        ApplyInfoType apply = new ApplyInfoType();
        apply.setPAN("622688");
        ExtensionsType ent = new ExtensionsType();
        // 如果您的类没有 @XmlRootElement 注释，那么您可以将其包装在<$ c $的实例中C>的JAXBElement
        // 创建QName，这个是关键，有了这个就不要使用@XmlRootElement注解了
        // QName qname = new QName("http://www.gi-de.com/gd-extionsion-1.0.0", "applyInfo");
        // JAXBElement<ApplyInfoType> jaxbPerson = new JAXBElement<ApplyInfoType>(qname, ApplyInfoType.class, apply);
        ObjectFactory objFac = new ObjectFactory();
        JAXBElement<ApplyInfoType> jaxbPerson = objFac.createApplyInfo(apply);

        ent.getAny().add(jaxbPerson);
        checkGlobalEligibilityRequest.getExtensions().add(ent);
        // 调用并返回结果
        Object res = userService.checkGlobalEligibility(checkGlobalEligibilityRequest);
        System.out.println(JSON.toJSONString(res));
    }

    /**
     * 测试6
     * 方式1.代理类工厂的方式,需要拿到对方的接口 -------适用与接口发布的服务
     * 接口代理类的发布
     * 
     * @throws Exception
     */
    public static void testCli6() throws Exception {
        // 借口地址
        String address = "http://127.0.0.1:8087/cjb-usual-study/hce";
        // 代理工厂
        JaxWsProxyFactoryBean jpfb = new JaxWsProxyFactoryBean();
        // 设置代理工厂地址
        jpfb.setAddress(address);
        // 设置借口类型
        jpfb.setServiceClass(GlobalEligibilityInfo.class);
        // cxf默认是关闭WS-Addressing的，需要手动打开
        jpfb.getFeatures().add(new WSAddressingFeature());
        // 创建一个代理借口实现
        GlobalEligibilityInfo userService = (GlobalEligibilityInfo) jpfb.create();
        // 参数
        ObjectFactory objFac = new ObjectFactory();
        DeployServiceResponseType deployServiceResponse = new DeployServiceResponseType();
        HceCardInfoType hceCard = new HceCardInfoType();
        hceCard.setIDValue("aaaa");

        JAXBElement<HceCardInfoType> fasd = objFac.createHceCardInfo(hceCard);
        ExtensionsType ent = new ExtensionsType();
        ent.getAny().add(fasd);
        deployServiceResponse.getExtensions().add(ent);

        // 调用并返回结果
        userService.deployService(deployServiceResponse);
        // System.out.println(JSON.toJSONString(res));
    }
}
