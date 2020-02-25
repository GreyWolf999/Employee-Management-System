package com.fangdada.springbootdemo1.dao;

import com.fangdada.springbootdemo1.domain.userBean;
import org.springframework.context.annotation.Bean;


import java.util.Collection;
public interface employeeDao {
    public Collection<userBean> getAll(int page,int limit);
    public int addEmp(userBean userBean);
    public int getCount();
    public int delEmp(int id);
    public int reg(String username,String password);
    public userBean getUser(int id);
    public Collection<userBean> getfind(int id);

    public int getfindCount(int id);
}
