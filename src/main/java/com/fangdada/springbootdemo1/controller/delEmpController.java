package com.fangdada.springbootdemo1.controller;

import com.fangdada.springbootdemo1.service.service;
import com.fangdada.springbootdemo1.service.serviceImpl.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class delEmpController {
    @Autowired
    service service;
    @ResponseBody
    @DeleteMapping("/delete/{id}")
//    @RequestMapping(value = "/delete/{id}",method =RequestMethod.POST)
    public String deletePollutionById(@PathVariable("id") int id){
        return service.del(id);
    }
}
