/**
 * 
 */
package com.cjb.test.study.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author junbo 2020年4月25日 下午1:40:19
 */
@RestController
public class TokenController {
    private final static Logger log = LoggerFactory.getLogger(TokenController.class);
    @Resource(name = "httsRestTemplate")
    private RestTemplate httsRestTemplate;

    @PostMapping(value = "/token")
    public String getUser(@RequestBody String id) {
        log.info(id);
        String res = httsRestTemplate.postForObject("https://localhost:8443/cjb-usual-study/webservice/token", id,
                String.class);
        return res;
    }
}
