package com.db.eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class HelloResource {

    @GetMapping("/message")
    public String check() {

        //System.out.println("***INSIDE HELLORESOURCE***");
        return "*****Entering into HelloResource class*****";
    }


    @Autowired
    public RestTemplate restTemplate;

    //System.out.println("***INSIDE HELLORESOURCE***");
    //public static String URL = "http://eureka-hello-server/rest/hello/server";

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping
    public String hello() {

        //System.out.println("***Inside rest controller of eureka-hello-client***");

        String url = "http://eureka-hello-server/server";
        System.out.println("The message is: "+ restTemplate.toString());
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback() {

        return "***Inside Hystrix fallback method***";
    }
}