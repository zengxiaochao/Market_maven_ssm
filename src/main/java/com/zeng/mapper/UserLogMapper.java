package com.zeng.mapper;

import com.zeng.entity.Userlog;
import org.apache.ibatis.annotations.Insert;

public interface UserLogMapper {

    @Insert("INSERT INTO user_log (login_name , login_time, login_ip, login_ornot, user_operation) VALUES(#{login_name}, #{login_time}, #{login_ip}, #{login_ornot}, #{user_operation})")
    void writelog(Userlog userlog);
}
