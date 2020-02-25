package com.fangdada.springbootdemo1.service.serviceImpl;

import com.fangdada.springbootdemo1.dao.DaoImpl.EmployeeDaoImpl;
import com.fangdada.springbootdemo1.dao.employeeDao;
import com.fangdada.springbootdemo1.domain.userBean;
import com.fangdada.springbootdemo1.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public  class impl implements service {
    @Autowired
    employeeDao employeeDao;
    @Override
    public String add(userBean userBean) {
        int s = employeeDao.addEmp(userBean);
        if (s>0){
            return "添加成功";
        }else return "添加失败";

    }

    @Override
    public String del(int id) {
        int i = employeeDao.delEmp(id);
        if (i>0){
            return "删除成功";
        }else return "删除失败";
    }

    @Override
    public String register(String username, String password) {
        int reg = employeeDao.reg(username, password);
        if (reg>0){
            return "注册成功";
        }else return "注册失败";
    }
}
