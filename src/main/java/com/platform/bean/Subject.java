package com.platform.bean;

import java.util.Date;

public class Subject {
    int subject_id;
    String subject_name;
    int create_by;
    Date create_date;
    Date expire_date;
    String subject_path;
    String courseDesc;
    String profile;
    int point;

    String subject_tag;


    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getCreate_by() {
        return create_by;
    }

    public void setCreate_by(int create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getSubject_path() {
        return subject_path;
    }

    public void setSubject_path(String subject_path) {
        this.subject_path = subject_path;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSubject_tag() {
        return subject_tag;
    }

    public void setSubject_tag(String subject_tag) {
        this.subject_tag = subject_tag;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subject_id +
                ", subject_name='" + subject_name + '\'' +
                ", create_by=" + create_by +
                ", create_date=" + create_date +
                ", expire_date=" + expire_date +
                ", subject_path='" + subject_path + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", profile='" + profile + '\'' +
                ", point=" + point +
                '}';
    }
}
