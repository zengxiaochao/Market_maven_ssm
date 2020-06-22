package com.zeng.service;

import com.zeng.entity.Indent;

import java.util.List;

public interface IndentService {
    List<Indent> allIndent();

    void insertIndent(Indent indent);
}
