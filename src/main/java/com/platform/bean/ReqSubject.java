package com.platform.bean;

public class ReqSubject {

    String courseName;
    String courseDesc;
    String createBy;
    String createDate;
    String expiredDate;
    String uploadCourseVideos;
    String profile;
    String courseTag;
    int creator;
    int point;

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getUploadCourseVideos() {
        return uploadCourseVideos;
    }

    public void setUploadCourseVideos(String uploadCourseVideos) {
        this.uploadCourseVideos = uploadCourseVideos;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
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

    public String getCourseTag() {
        return courseTag;
    }

    public void setCourseTag(String courseTag) {
        this.courseTag = courseTag;
    }

    @Override
    public String toString() {
        return "ReqSubject{" +
                "courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", expiredDate='" + expiredDate + '\'' +
                ", uploadCourseVideos='" + uploadCourseVideos + '\'' +
                ", profile='" + profile + '\'' +
                ", creator=" + creator +
                '}';
    }
}
