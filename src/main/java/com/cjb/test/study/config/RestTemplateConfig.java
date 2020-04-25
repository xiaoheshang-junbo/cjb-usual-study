/**
 * 
 */
package com.cjb.test.study.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置
 * 
 * @author junbo 2020年4月25日 下午2:07:18
 */

@Configuration
public class RestTemplateConfig {
    private String keystoreFile;
    private String keystorePassword;
    private String truststoreFile;
    private String truststorePassword;

    /**
     * 普通的resttemplate
     * 
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);// 单位为ms
        factory.setReadTimeout(5000);// 单位为ms

        RestTemplate restTemplate = new RestTemplate(factory);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        // messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    /**
     * resttemplate访问https服务，无证书
     * 
     * @return
     */
    @Bean("httsRestTemplate")
    public RestTemplate httsRestTemplate() {
        SimpleClientHttpRequestFactory factory = new HttpsClientReqNoCertFactory();
        factory.setConnectTimeout(15000);// 单位为ms
        factory.setReadTimeout(5000);// 单位为ms

        RestTemplate restTemplate = new RestTemplate(factory);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        // messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    /**
     * resttemplate访问https服务，有证书
     * 
     * @return
     * @throws IOException
     * @throws CertificateException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws UnrecoverableKeyException
     * @throws KeyManagementException
     */
    @Bean("httsRestTemplateByCert")
    public RestTemplate httsRestTemplateByCert() {
        SimpleClientHttpRequestFactory factory = new HttpsClientReqByCertFactory(keystoreFile, keystorePassword,
                truststoreFile, truststorePassword);
        factory.setConnectTimeout(15000);// 单位为ms
        factory.setReadTimeout(5000);// 单位为ms

        RestTemplate restTemplate = new RestTemplate(factory);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        // messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

}
