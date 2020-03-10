package com.platform.service;

import com.platform.bean.RespQues;
import com.platform.dao.QuesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesService {
    @Autowired
    QuesDao quesDao;

    public List<RespQues> selectAllQuesBySubject(int subjectId){
       return quesDao.selectAllQuesBySubject(subjectId);
    }

    public void insertSingleQues(RespQues respQues){
        quesDao.insertSingleQues(respQues);
    }
}
