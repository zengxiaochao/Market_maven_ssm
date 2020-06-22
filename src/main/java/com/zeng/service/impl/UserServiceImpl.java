package com.zeng.service.impl;

import com.zeng.entity.Address;
import com.zeng.entity.User;
import com.zeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements com.zeng.service.UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * login
     */
    @Override
    public User getUser(String name,String pwd){
        return userMapper.Login(name,pwd);
    }

    @Override
    public boolean checkUser(String re_name) {
        if(userMapper.checkU(re_name)!=null)
            return true;
        return false;
    }

    @Override
    public void addUser(User user) {
        userMapper.AddUser(user);
    }

    @Override
    public void addAddress(Address address) {
        userMapper.AddAddress(address);
    }

    @Override
    public Address getAddress(String name) {
        return userMapper.Get_Address(name);
    }


}
