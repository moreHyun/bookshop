package com.greedy.bookshop.sales.model.dao;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper
{
    int insertCart(long bookCode, long userCode);
}
