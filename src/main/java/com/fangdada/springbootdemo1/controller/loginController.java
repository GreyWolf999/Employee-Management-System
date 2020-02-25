package com.fangdada.springbootdemo1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {
    @PostMapping(value ="/logined")
    public String login(@RequestParam("Username") String Username,
                        @RequestParam("Password") String Password,
                        Map<String,String> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(Username)&&"123456".equals(Password)){
//            这里进行登陆成功后重定向返回这个值  redirect:/main.html 代表重定向
            session.setAttribute("loginUser",Username);
            return "redirect:/main.html";
        }else {
        map.put("msg","密码或用户名错误 登陆失败");
        return "login";
        }
    }
    @RequestMapping("/hallo")
    public String hallo(){
        return "emp/new";
    }


}
