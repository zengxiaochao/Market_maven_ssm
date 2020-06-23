package com.zeng.service;

import com.zeng.entity.Carts;
import com.zeng.entity.User;

import java.util.List;

public interface CartsService {
    void insertCarts(Carts carts);

    List<Carts> selectCart(int id);

    void deleCarts(int user_id, String carts_name);

    void all_buy(int user_id);
}
