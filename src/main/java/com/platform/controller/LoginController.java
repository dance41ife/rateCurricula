package com.platform.controller;

import com.platform.bean.RespMsg;
import com.platform.bean.User;
import com.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord){
        int count = userService.findSingleUserByNamePassW(userName,passWord);
        RespMsg respMsg = new RespMsg();
        if(count == 0){
            respMsg.setCode("failure");
            respMsg.setMessage("用户名密码不存在");
            respMsg.setStatus(-100);
        }else {
            User uInfo = userService.findSingleUser(userName);
            System.out.println(uInfo);
            respMsg.setCode("success");
            respMsg.setMessage("id: " + uInfo.getUser_id() + "," + "role: " +uInfo.getRole());
            respMsg.setStatus(200);
        }
        return respMsg;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg register(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord){
        RespMsg respMsg = new RespMsg();
        try{
            userService.addUser(userName,passWord);
        }catch (Exception e){
            respMsg.setCode("failure");
            respMsg.setMessage("注册失败");
            respMsg.setStatus(-100);
            return respMsg;
        }
        respMsg.setCode("success");
        respMsg.setMessage("注册成功");
        respMsg.setStatus(200);
        return respMsg;
    }

}
