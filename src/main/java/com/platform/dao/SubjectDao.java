package com.platform.dao;

import com.platform.bean.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SubjectDao {
    Subject findOneSubject();

    void insertSingleSubject(Subject subject);

    List<RespSubject> selectAllSubjectByUserName(int userId);

    List<RespSubject> selectAllSubject();

    void insertSingleRel(Rel rel);

    List<Rel> getUserSubjectRelByUserId(int userId);

    List<SubjectCreatorRes> selectAllSubjectByCreator(int userId);

    void deleteUserSubjectRelation(int userId, int subjectId);

    List<CommentViewModel> getCommentBySubjectId(int subjectId);

    void insertComment(int userId,int subjectId,String comment, Date date);

    List<RespSubject> selectAllValidSubjectByUserName(String user_name);

}
