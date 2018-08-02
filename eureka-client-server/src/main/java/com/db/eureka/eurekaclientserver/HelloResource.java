package com.db.eureka.eurekaclientserver;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class HelloResource {

    @GetMapping
    public String hello() {
        System.out.println("***Inside eureka-hello-server***");
        return  "Hello Developers!!";
    }
}
