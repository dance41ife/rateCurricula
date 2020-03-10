package com.platform.utils;

import com.platform.bean.ReqSubject;
import com.platform.bean.Subject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeObject {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static Subject getSubjectByReq(ReqSubject req,int Subject_id) throws ParseException {
        Subject subject = new Subject();
        subject.setSubject_path(req.getUploadCourseVideos());
        subject.setSubject_name(req.getCourseName());
        subject.setCreate_by(Subject_id);
        subject.setCreate_date(new Date());
        System.out.println(req.getExpiredDate());
        subject.setExpire_date(format.parse(req.getExpiredDate()));
        subject.setCourseDesc(req.getCourseDesc());
        subject.setProfile(req.getProfile());
        subject.setPoint(req.getPoint());
        subject.setSubject_tag(req.getCourseTag());
        return subject;
    }
}
