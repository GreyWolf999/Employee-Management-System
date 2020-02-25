package com.fangdada.springbootdemo1.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class AjaxResponse {
    private  Integer code;
    private  String msg;
    private  Integer count;
    private  Collection<userBean> datas;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Collection<userBean> getDatas() {
        return datas;
    }

    public void setDatas(Collection<userBean> datas) {
        this.datas = datas;
    }

    public static String getAjaxData(Integer coun, Collection<userBean> userBeans) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
       AjaxResponse response=new AjaxResponse();
       response.setCode(0);
       response.setMsg("");
       response.setCount(coun);
       response.setDatas(userBeans);
        return objectMapper.writeValueAsString(response);
    }
}
