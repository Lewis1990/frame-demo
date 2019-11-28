package com.lewis.controller;

import com.lewis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
        return userService.index();
    }

    @GetMapping("/list")
    public String list(){
        return "COMSUMER";
    }
}
