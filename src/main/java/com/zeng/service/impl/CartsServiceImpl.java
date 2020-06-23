package com.zeng.service.impl;


import com.zeng.entity.Carts;
import com.zeng.entity.Indent;
import com.zeng.entity.User;
import com.zeng.mapper.CartsMapper;
import com.zeng.mapper.GoodsMapper;
import com.zeng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsServiceImpl implements com.zeng.service.CartsService {
    @Autowired
    private CartsMapper cartsMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public void insertCarts(Carts carts) {
        cartsMapper.insert_Carts(carts);
    }

    @Override
    public List<Carts> selectCart(int id) {
        return cartsMapper.allMyCarts(id);
    }

    @Override
    public void deleCarts(int user_id, String carts_name) {
        cartsMapper.deCarts(user_id,carts_name);
    }

    @Override
    public void all_buy(int user_id) {

        cartsMapper.allBuyEd(user_id);
    }

}
