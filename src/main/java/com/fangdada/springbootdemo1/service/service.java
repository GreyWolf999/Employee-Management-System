package com.fangdada.springbootdemo1.service;

import com.fangdada.springbootdemo1.domain.userBean;

public interface service {
    public String add(userBean userBean);
    public String del(int id);
    public String register(String username,String password);
}
