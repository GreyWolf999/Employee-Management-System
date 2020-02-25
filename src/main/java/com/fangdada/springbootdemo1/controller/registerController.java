package com.fangdada.springbootdemo1.controller;

import com.fangdada.springbootdemo1.domain.usedata;
import com.fangdada.springbootdemo1.service.service;
import com.fangdada.springbootdemo1.service.serviceImpl.impl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class registerController {

    service service=new impl();
    @PostMapping("/register")
    public String register(usedata usedata){
        System.out.println(usedata);
        return "login";
    }


}
