package com.dehu.actuator_hu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/sayHi")
    public String sayHi() throws InterruptedException {

        Thread.sleep(5000);

        System.out.println("success");

        return "success";
    }

}
