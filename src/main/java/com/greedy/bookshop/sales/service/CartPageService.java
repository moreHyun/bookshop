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
            b.addAll(mapper.selectBookCart(cart.getBookCode()));

        for (BookDTO bookDTO : b)
            f.addAll(mapper.selectBookFile(bookDTO.getBookCode()));

        m.put("cart",c);
        m.put("book",b);
        m.put("file",f);

        return m;
    }

    public String UpdateStatus(long cartCode,long userCode)
    {
        CartDTO cart = mapper.selectCart2(cartCode,userCode);
        int n = 0;
        String m = "";
        if(cart == null)
        {
            n = mapper.insertBuyitem(cartCode,userCode);
        }
        else
        {
            n = mapper.UpdateStatus(cart, userCode);
        }
        if(n == 1)
            m = "네";
        return m;
    }

    public void deleteItem(long cartCode,long userCode)
    {
        int r = 0;
        String m = "";
        log.info("u : " + userCode);
        mapper.deleteItem(cartCode,userCode);
    }
}
