package com.zeng.service.impl;


import com.zeng.entity.Carts;
import com.zeng.entity.Indent;
import com.zeng.mapper.CartsMapper;
import com.zeng.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartsServiceImpl implements com.zeng.service.CartsService {
    @Autowired
    private CartsMapper cartsMapper;



    @Override
    public void insertCarts(Carts carts) {
        cartsMapper.insert_Carts(carts);
    }

}
