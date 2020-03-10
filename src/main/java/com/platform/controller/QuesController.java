package com.platform.controller;

import com.platform.bean.RespMsg;
import com.platform.bean.RespQues;
import com.platform.bean.Subject;
import com.platform.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuesController {
    @Autowired
    QuesService quesService;

    @RequestMapping(value = "/getAllQuesBySubject",method = RequestMethod.POST)
    @ResponseBody
    public List<RespQues> getAllQuesBySubject(@RequestParam("subjectId") int subjectId){
        return quesService.selectAllQuesBySubject(subjectId);
    }

    @RequestMapping(value = "/addQues",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg addQues(@RequestBody RespQues ques){
        RespMsg respMsg = new RespMsg();
        try{
            quesService.insertSingleQues(ques);
        }catch (Exception e){
            respMsg.setStatus(-100);
            respMsg.setMessage(e.getMessage());
            respMsg.setCode("failure!");
            return respMsg;
        }
        respMsg.setStatus(200);
        respMsg.setCode("success!");
        return respMsg;
    }

}
