package com.fangdada.springbootdemo1.controller;

import com.fangdada.springbootdemo1.dao.employeeDao;
import com.fangdada.springbootdemo1.domain.AjaxResponse;
import com.fangdada.springbootdemo1.domain.userBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class empListerController {

    Map<String,Object> result=new HashMap<>();
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    employeeDao employeeDao;
    Map<String,Object> map=new HashMap<>();
    @ResponseBody
    @GetMapping("/empData")
    public String empList(@RequestParam("page") int page,
                          @RequestParam("limit") int limit,
                          @RequestParam(value = "id",defaultValue = "0") int id,
                          HttpServletRequest request
                          ) throws IOException{
      if (id==0){
          Collection<userBean> alloffice = employeeDao.getAll(page,limit);
          //layui的数据格式
          result.put("code",0);
          result.put("msg", "");
          result.put("count",employeeDao.getCount());
          result.put("data", alloffice);
          return objectMapper.writeValueAsString(result);
      } else {
            map.put("id",id);
            Collection<userBean> alloffice2 = employeeDao.getfind(id);
            //layui的数据格式
            result.put("code",0);
            result.put("msg", "");
            result.put("count",employeeDao.getfindCount(id));
            result.put("data", alloffice2);
            return objectMapper.writeValueAsString(result);
        }

//        return AjaxResponse.getAjaxData(employeeDao.getCount(),alloffice);
    }
    @RequestMapping("/ListShow")
    public String empList(){
        return "emp/empL";
    }
}
