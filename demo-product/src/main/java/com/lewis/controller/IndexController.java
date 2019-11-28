package com.lewis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String index(){
        return "I am the ProviderServer`s Index";
    }

    @GetMapping("/list")
    public String list(){
        return "PROVIDER";
    }
}
