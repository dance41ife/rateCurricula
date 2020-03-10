package com.platform.dao;

import com.platform.bean.RespQues;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuesDao {
    void insertSingleQues(RespQues ques);

    List<RespQues> selectAllQuesBySubject(int subjectId);
}
