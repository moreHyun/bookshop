package com.greedy.bookshop.sales.model.dao;


import com.greedy.bookshop.sales.model.dto.BookDTO;
import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.model.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper
{
    int insertCart(long bookCode, long userCode);

    List<CartDTO> selectUserCart(long userCode);

    List<BookDTO> selectBookCart(long bookCode);

    List<FileDTO> selectBookFile(long bookCode);

    CartDTO selectCart(long bookCode, long userCode);

    int inneritem(long bookCode, long userCode,CartDTO cart);

    int insertBuyitem(long bookCode, long userCode);

    int upDateItem(long bookCode, long userCode,CartDTO cart);

    int UpdateStatus(CartDTO cart,long userCode);

    void deleteItem(long cartCode, long userCode);

    CartDTO selectCart2(long cartCode, long userCode);
}
