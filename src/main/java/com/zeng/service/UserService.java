package com.zeng.service;

import com.zeng.entity.Address;
import com.zeng.entity.User;

public interface UserService {
    User getUser(String name,String pwd);
    boolean checkUser(String re_name);

    void addUser(User user);

    void addAddress(Address address);

    Address getAddress(String name);
}
