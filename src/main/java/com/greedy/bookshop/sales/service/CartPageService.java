package com.greedy.bookshop.sales.service;

import com.greedy.bookshop.sales.model.dao.CartMapper;
import com.greedy.bookshop.sales.model.dto.BookDTO;
import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.model.dto.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public Map<String, Object> selectUserCart(long userCode)
    {
        log.info("Service 들어옴");
        Map<String,Object> m = new HashMap<>();
        List<FileDTO> f = new ArrayList<>();
        List<BookDTO> b = new ArrayList<>();
        List<CartDTO> c = mapper.selectUserCart(userCode);
        for(CartDTO cart : c)
        {
            log.info("Service] b : " + "들어옴");
            b.addAll(mapper.selectBookCart(cart.getBookCode()));
            log.info("Service] b value : " + b);
        }
        for(int i = 0 ; i < b.size(); i++)
        {
           f.addAll(mapper.selectBookFile(b.get(i).getBookCode()));

        }
        m.put("cart",c);
        m.put("book",b);
        m.put("file",f);
        for(int i = 0 ; i < m.size(); i++)
        {
            log.info("Serivce] : m " + i + " : " + m);
        }
        return m;
    }
}
