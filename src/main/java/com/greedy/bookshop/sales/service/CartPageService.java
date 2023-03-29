package com.greedy.bookshop.sales.service;

import com.greedy.bookshop.sales.model.dao.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class CartPageService
{
    private final CartMapper mapper;

    public CartPageService(CartMapper mapper)
    {
        this.mapper = mapper;
    }

    public int insertCart(long bookCode,long userCode)
    {
       int r = mapper.insertCart(bookCode,userCode);

       return r;
    }
}
