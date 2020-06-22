package com.zeng.service.impl;


import com.zeng.entity.Goods;
import com.zeng.entity.Indent;
import com.zeng.mapper.GoodsMapper;
import com.zeng.mapper.IndentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentServiceImpl implements com.zeng.service.IndentService {

    @Autowired
    private IndentMapper indentMapper;


    @Override
    public List<Indent> allIndent() {
        return indentMapper.selectIndent();
    }

    @Override
    public void insertIndent(Indent indent) {
        indentMapper.select_Indent(indent);
    }


}
