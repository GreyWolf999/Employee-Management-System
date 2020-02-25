package com.fangdada.springbootdemo1.component;


import org.springframework.cglib.core.Local;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver{
    Locale locale=Locale.getDefault();
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        //获取请求中以”l“为健的值 也就是l='zh_CN'
        if (!StringUtils.isEmpty(l)){
            //进行判断 并且使用split来分割字符串成为一个数组
            String[] s = l.split("_");
            //调用locale 第一个参数时语种 第二个参数时国家
          locale= new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
