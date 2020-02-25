package com.fangdada.springbootdemo1.controller;

import com.fangdada.springbootdemo1.dao.DaoImpl.EmployeeDaoImpl;
import com.fangdada.springbootdemo1.domain.userBean;

import com.fangdada.springbootdemo1.service.service;
import com.fangdada.springbootdemo1.service.serviceImpl.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class addEmpController {

    @Autowired
    service service;
    @RequestMapping("/addData")
    public String addData(){
        return "emp/addEmp";
    }
    @GetMapping("/addData2")
    public String addData2(userBean userBean,HttpServletRequest request){
        String upadata = service.add(userBean);
        request.setAttribute("updata",upadata);
        return "emp/empL";
    }
}
