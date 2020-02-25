package com.fangdada.springbootdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class impageController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    @RequestMapping("/showData")
    public String show(){
        return "systemData";
    }
    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String image(HttpServletRequest req, MultipartFile image) {
        StringBuffer url = new StringBuffer();
        String filePath = "/blogimg/" +sdf.format(new Date()) ;
        System.out.println(filePath);
        //获取项目的绝对路径 然后以此来创建一个用来保存图片的文件夹
        String imgFolderPath = req.getServletContext().getRealPath(filePath);
        System.out.println(imgFolderPath);
        File imgFolder = new File(imgFolderPath);
        if (!imgFolder.exists()) {
            imgFolder.mkdirs();
        }
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append(filePath);
        System.out.println(url);
        String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");
        System.out.println(imgName);
     return "main";
    }
}
