package com.daiyuchuan.security.distributed.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/r1")
    public String r1(){
        return "访问资源r1";
    }
}
