package com.platform.service;

import com.platform.bean.RespSubject;
import com.platform.bean.User;
import com.platform.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User findSingleUser(String userName){
        return userDao.findSingleUser(userName);
    }

    public int findSingleUserByNamePassW(String userName,String passWord){
        return userDao.findSingleUserByNamePassW(userName,passWord);
    }

    public void addUser(String userName,String passWord){
        userDao.addUser(userName,passWord);
    }

    public void UpdateUserPoint(double point,String userName){
        userDao.UpdateUserPoint(point,userName);
    }

}
