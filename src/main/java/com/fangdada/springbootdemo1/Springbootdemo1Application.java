package com.fangdada.springbootdemo1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
public class Springbootdemo1Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Springbootdemo1Application.class, args);



    }


}
