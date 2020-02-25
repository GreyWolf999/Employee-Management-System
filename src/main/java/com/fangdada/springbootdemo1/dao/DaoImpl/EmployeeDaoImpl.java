package com.fangdada.springbootdemo1.dao.DaoImpl;

import com.fangdada.springbootdemo1.dao.employeeDao;
import com.fangdada.springbootdemo1.domain.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class EmployeeDaoImpl implements employeeDao{
    @Autowired
JdbcTemplate jdbcTemplate;
    private Collection<userBean> alloffice=new ArrayList<userBean>();
    public Collection<userBean> getAll(int page,int limits){
        String sql="select * from office limit "+(page-1)*limits+","+limits;
        alloffice = jdbcTemplate.query(sql, new BeanPropertyRowMapper<userBean>(userBean.class));
        return alloffice;
    }
    public int addEmp(userBean userBean){
        int x=(int)(Math.random()*50)+1;
        String y="100"+x;
        int count = Integer.parseInt(y);
        String sql="insert into office values(?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, count, userBean.getName(), userBean.getAge(), userBean.getGender(), userBean.getPhoneNumber(), userBean.getSkillLevel()
                , userBean.getJobNumber(), userBean.getUserLevel(), userBean.getProvince());
        return update;
    }
    public int getCount(){
        String sql="SELECT COUNT(*) FROM office";
        return jdbcTemplate.queryForObject(sql, int.class);
    }

    @Override
    public int delEmp(int id) {
        String sql="delete from office where id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int reg(String username, String password) {
        String sql="insert into userdata values(?,?)";
       return jdbcTemplate.update(sql,username,password);
    }

    @Override
    public userBean getUser(int id) {
        String sql="select * from office where id=?";
        return  jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<userBean>(userBean.class), id);
    }

    @Override
    public Collection<userBean> getfind(int id) {
        String sql="select * from office where id=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<userBean>(userBean.class)
        ,id);
    }
    @Override
    public int getfindCount(int id){
        String sql="SELECT COUNT(*) FROM office where id=?";
        return jdbcTemplate.queryForObject(sql,int.class,id);
    }
}
