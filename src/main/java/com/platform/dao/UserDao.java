package com.platform.dao;

import com.platform.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findSingleUser(String userName);

    int findSingleUserByNamePassW(@Param("userName") String userName,@Param("passWord")String passWord);

    void addUser(@Param("userName")String userName, @Param("passWord")String passWord);

    void UpdateUserPoint(double point,String userName);

}
