package com.platform.service;

import com.platform.bean.*;
import com.platform.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

    public Subject findOneSubject(){
        return subjectDao.findOneSubject();
    }

    public void insertSingleSubject(Subject subject){
        subjectDao.insertSingleSubject(subject);
    }

    public List<RespSubject> selectAllSubjectByUserName(int userId){
        return subjectDao.selectAllSubjectByUserName(userId);
    }

    public List<RespSubject> selectAllSubject(){
        return subjectDao.selectAllSubject();
    }

    public void insertSingleRel(Rel rel){
        subjectDao.insertSingleRel(rel);
    }

    public List<Rel> getUserSubjectRelByUserId(int id){
        List<Rel> result = subjectDao.getUserSubjectRelByUserId(id);

        return result.stream().distinct().collect(Collectors.toList());
    }

    public List<SubjectCreatorRes> selectAllSubjectByCreator(int userId){
       return subjectDao.selectAllSubjectByCreator(userId);
    }

    public void deleteUserSubjectRelation(int userId,int subjectId){
        subjectDao.deleteUserSubjectRelation(userId,subjectId);
    }

    public void insertComment(int userId, int subjectId, String comment, Date date){
        subjectDao.insertComment(userId,subjectId,comment,date);
    }

    public List<CommentViewModel> getCommentBySubjectId(int subjectId){
        return subjectDao.getCommentBySubjectId(subjectId);
    }
    public List<RespSubject> selectAllValidSubjectByUserName(String user_name){
        return subjectDao.selectAllValidSubjectByUserName(user_name);
    }


}
