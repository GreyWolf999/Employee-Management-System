package com.fangdada.springbootdemo1.MyConfig;
import com.fangdada.springbootdemo1.component.LoginHandInterceptors;
import com.fangdada.springbootdemo1.component.MyLocalResolver;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.sql.DataSource;
@Configuration
//直接实现WebConfiguer接口 实现对spring boot 本身的配置进行修改 添加自己的配置
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    //添加视图处理器 可以接收请求 并交由tyhmeleaf渲染页面
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("main.html");

    }
    @Bean //将这个加入容器中 交由spring进行执行
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

//    重写注册拦截器的方法 自己写的拦截器 我们需要在spring容器中注册 才可以使spring使用
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        这里的”/**“是表示拦截所有的类路径下的请求也就是项目路径 excludePathPatterns表示可以放行的路径
        registry.addInterceptor(new LoginHandInterceptors()).addPathPatterns("/**").excludePathPatterns("/login.html","/logined","/",
                "/css/**","/images/**","/js/**","/success.html");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}
