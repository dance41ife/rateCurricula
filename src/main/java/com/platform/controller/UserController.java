package com.platform.controller;

import com.platform.bean.RespMsg;
import com.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "addUserPoint",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg addUserPoint(@RequestParam("point")double point,@RequestParam("userName") String userName){
        RespMsg msg = new RespMsg();
        try{
            userService.UpdateUserPoint(point,userName);
            msg.setCode("success");
            msg.setMessage("更新学分成功");
            msg.setStatus(200);
            return msg;
        }catch (Exception e){
            e.printStackTrace();
            msg.setCode("failure");
            msg.setMessage(e.getMessage());
            msg.setStatus(-100);
            return msg;
        }
    }
}
