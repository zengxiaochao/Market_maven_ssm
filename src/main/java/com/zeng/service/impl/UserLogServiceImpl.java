package com.zeng.service.impl;


import com.zeng.entity.Indent;
import com.zeng.entity.Userlog;
import com.zeng.mapper.IndentMapper;
import com.zeng.mapper.UserLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements com.zeng.service.UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;




    @Override
    public void insertIndent(Userlog userlog) {
        userLogMapper.writelog(userlog);
    }
}
