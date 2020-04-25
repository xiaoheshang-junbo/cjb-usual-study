/**
 * 
 */
package com.cjb.test.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author junbo 2020年4月25日 下午1:40:19
 */
@RestController
public class HceController {
    private final static Logger log = LoggerFactory.getLogger(HceController.class);
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/hce")
    public String getUser(@RequestBody String id) {
        log.info(id);
        String res = restTemplate.postForObject("http://localhost:8087/cjb-usual-study/webservice/hce", id,
                String.class);
        return res;
    }
}
