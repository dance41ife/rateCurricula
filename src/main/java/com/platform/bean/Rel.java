package com.platform.bean;

public class Rel {
    int user_id;
    int subject_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }


    @Override
    public boolean equals(Object obj) {
        Rel input = (Rel)obj;
        return this.user_id == input.user_id && this.subject_id == input.subject_id;
    }
}
