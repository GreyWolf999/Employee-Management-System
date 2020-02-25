package com.fangdada.springbootdemo1;

import com.fangdada.springbootdemo1.domain.userBean;
import com.zaxxer.hikari.util.DriverDataSource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class Springbootdemo1ApplicationTests {

    @Autowired
DataSource dataSource;
@Autowired
JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads(){
        System.out.println(dataSource.getClass());
        System.out.println(jdbcTemplate);
    }

}
