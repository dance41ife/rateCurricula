package com.platform.bean;

public class RespQues {
    int ques_id;
    int subject_id;
    String ques_type;
    String ques_desc;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String true_answer;
    int create_by;


    public int getQues_id() {
        return ques_id;
    }

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getQues_type() {
        return ques_type;
    }

    public void setQues_type(String ques_type) {
        this.ques_type = ques_type;
    }

    public String getQues_desc() {
        return ques_desc;
    }

    public void setQues_desc(String ques_desc) {
        this.ques_desc = ques_desc;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getTrue_answer() {
        return true_answer;
    }

    public void setTrue_answer(String true_answer) {
        this.true_answer = true_answer;
    }

    public int getCreate_by(){
        return create_by;
    }

    public void setCreate_by(int create_by){
        this.create_by = create_by;
    }
    @Override
    public String toString() {
        return "RespQues{" +
                "ques_id=" + ques_id +
                ", subject_id=" + subject_id +
                ", ques_type='" + ques_type + '\'' +
                ", ques_desc='" + ques_desc + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", true_answer='" + true_answer + '\'' +
                '}';
    }
}
