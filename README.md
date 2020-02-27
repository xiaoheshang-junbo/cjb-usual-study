多端口发布
============

webservice
===========
##### 1、cfg配置
根据cfg分发路径：http://localhost:8087/cjb-usual-study/webservice/user-api?wsdl
##### 2、JDK自带工具根据wsdl文件生成java代码
Token实例：
wsimport -encoding utf-8 -keep -target 2.1 -s E:\eclipse-workspace\cjb-usual-study\src\main\java -p com.cjb.test.study.bean.token -verbose -Xnocompile AppManageToStandardProvider.wsdl <br>
HCE实例：使用java绑定，
wsimport -encoding utf-8 -keep -target 2.1  -extension -d E:\eclipse-workspace\cjb-usual-study\src\main\java -p com.cjb.test.study.bean.hce -verbose -Xnocompile GlobalEligibilityInfo.wsdl <br>
xjc -encoding utf-8 -target 2.1 -extension -d E:\eclipse-workspace\cjb-usual-study\src\main\java -p com.cjb.test.study.bean.hce -no-header gd-extension-1.0.0.xsd <br>

| Option | Description |
| :---: | :---: |
| -d <directory> | 指定输出目录 |
| -b <path> | 指定JAXWS或者JAXB的绑定文件，可以多个 |
| -B <jaxbOption> | 指定JAXB的参数，透传给JAXB命令 |
| -catalog | 绑定外部WSDL或XSD，解决外部WSDL或者XSD引用 |
| -extension | Allow vendor extensions (functionality not specified by the specification). Use of extensions may result in applications that are not portable or may not interoperate with other implementations. |
| -help | 显示帮助 |
| -httpproxy:<host>:<port> | 指定一个HTTP代理 |
| -keep | 保留源文件 |
| -p <pkg> | 指定包名 |
| -s <directory> | 指定源代码存放目录 |
| -encoding <encoding> | 指定编码格式，例如UTF-8 |
| -verbose | 指定输出命令执行的详细信息 |
| -version | 显示版本 |
| -fullversion | 显示详细的版本信息 |
| -clientjar <jarfile> | Creates the jar file of the generated artifacts along with the WSDL metadata required for invoking the web service. |
| -wsdllocation <location> | @WebServiceClient.wsdlLocation value. |
| -target <version> | 指定JAX-WS的版本，默认是 2.2. |
| -quiet | 静默执行该命令，不在屏幕输出信息 |
| -XadditionalHeaders | Map the headers not bound to request or response message to Java method parameters. |
| -Xauthfile | File to carry authorization information in the format http://username:password@example.org/stock?wsdl. Default value is  |$HOME/.metro/auth |
| -Xdebug | 显示DEBUG信息 |
| -XdisableAuthenticator | Disables Authenticator used by JAX-WS RI, -Xauthfile option will be ignored if -XdisableAuthenticatoris set. |
| -Xno-addressing-databinding | 不使用JDK的Addressing，生成自己的EndpointReferenceType |
| -Xnocompile | 不编译生成的源码 |
| -XdisableSSLHostnameVerification | Disbales the SSL Hostname verification while fetching the wsdls. |

springcloud 组件
=========================