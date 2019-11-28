package com.lewis.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "DEMO-PRODUCT")
public interface UserService {

    @RequestMapping("/index")
    String index();

}
