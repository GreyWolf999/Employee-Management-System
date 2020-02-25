package com.fangdada.springbootdemo1.controller;

import com.fangdada.springbootdemo1.dao.employeeDao;
import com.fangdada.springbootdemo1.domain.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class editoEmpController {

    @Autowired
    employeeDao employeeDao;
    @RequestMapping("/edito/{id}")
    public String editoData(@PathVariable("id") int id,
                            HttpServletRequest request){
        request.setAttribute("userdata",employeeDao.getUser(id));
        return "emp/editoEmp";
    }
}
