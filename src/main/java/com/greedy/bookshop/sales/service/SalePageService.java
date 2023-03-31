package com.greedy.bookshop.sales.service;

import com.greedy.bookshop.common.paging.PageDTO;
import com.greedy.bookshop.common.paging.Pagenation;
import com.greedy.bookshop.sales.model.dao.BookMapper;
import com.greedy.bookshop.sales.model.dao.CartMapper;
import com.greedy.bookshop.sales.model.dao.CategoryMapper;
import com.greedy.bookshop.sales.model.dto.BookDTO;
import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.model.dto.CategoryDTO;
import com.greedy.bookshop.sales.model.dto.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SalePageService
{
    private final CategoryMapper cMapper;
    private final BookMapper bMapper;
    private final CartMapper cartMapper;

    public SalePageService(CategoryMapper cMapper, BookMapper bMapper, CartMapper cartMapper)
    {
        this.cMapper = cMapper;
        this.bMapper = bMapper;
        this.cartMapper = cartMapper;
    }
    
    public List<CategoryDTO> selectCategoryAll()
    {
        log.info("카테고리 코드 받아오는중");
        List<CategoryDTO> category = cMapper.selcetAllCategory();
        log.info("categoryDTO : " + category);
        log.info("카테고리 코드 받았음");
        return category;
    }

    public List<BookDTO> selectBookAll()
    {
        log.info("Book 정보 받아오는중");
        List<BookDTO> book = bMapper.selcetAllBook();
        log.info("Book정보 받아왔음");
        for (BookDTO b : book)
            log.info("book : " + b);
        return book;
    }

    public List<FileDTO> selectFileAll()
    {
        log.info("file 정보 받아오는중");
        List<FileDTO> file = bMapper.selcetAllFile();
        for(FileDTO f : file)
            log.info("file : " + f);
        log.info("file 정보 받아왔음");

        return file;
    }

    public List<BookDTO> selectBookCategory(long c)
    {
        log.info("categoryCode 받아옴 : " + c);
        List<BookDTO> book = bMapper.selectBookCategory(c);
        for(BookDTO b : book)
            log.info("BookList : " + b);

        return book;
    }

    public List<FileDTO> selectFileCategory(long b)
    {
        log.info("bookCode 받아옴 : " + b);
        List<FileDTO> file = bMapper.selectFileCategory(b);
        log.info("Servie FIle : " + file);
        return file;
    }

    public String selectCategoryName(long c)
    {
        String t = cMapper.selectTopCategoryName(c);
        String s = cMapper.selectSubCategoryName(c);
        String ts = t + " " + s;
        log.info("ts : " + ts);
        return ts;
    }

    /*public PageDTO Paging(long categoryCode, int page,int totalCount,String saerchValue)
    {
        totalCount = bMapper.selectTotalCount(categoryCode);
        int limit = 1;
        int buttonAmount = 0;
        PageDTO pageDTO = Pagenation.PageCriteria(page,totalCount,limit,buttonAmount,saerchValue);

        return pageDTO;
    }
*/
    public Map<String, Object> selectBookList(int page, Map<String, String> value)
    {
        String selectCategoryName = "";
        int totalCount = 0;
        List<FileDTO> file = new ArrayList<>();
        Map<String,String> searchValue = new HashMap<>();
        log.info("Service) value : " + value.get("category"));
        if(!value.get("category").isEmpty())
        {
            searchValue.put("type","category");
            searchValue.put("value",value.get("category"));
            totalCount = bMapper.selectTotalCount(searchValue);
            selectCategoryName = selectCategoryName(Integer.valueOf(value.get("category")));
            log.info("Service] totalCount = " + totalCount);
        }
        else if(!value.get("search").isEmpty())
        {
            searchValue.put("type","search");
            searchValue.put("value",value.get("search"));
            totalCount = bMapper.selectTotalCount(searchValue);
            selectCategoryName = value.get("search") + " 에 대한 검색 결과 입니다";
            log.info("Service] totalCount = " + totalCount);
        }

        int limit = 5;
        int buttonAmount = 0;
        log.info("value" + searchValue.get("value"));
        PageDTO pageDTO = Pagenation.PageCriteria(page,totalCount,limit,buttonAmount,searchValue.get("type"),searchValue.get("value"));
        log.info("pageDTO : " + pageDTO);
        List<BookDTO> book = bMapper.selcetBookList(pageDTO);
        for (int i = 0; i < book.size(); i++)
        {
            file.addAll(bMapper.searchFile(book.get(i).getBookCode()));
        }
        log.info("file : " + file);
        Map<String , Object> ListAndPage = new HashMap<>();
        ListAndPage.put("paging",pageDTO);
        ListAndPage.put("file",file);
        ListAndPage.put("book",book);
        ListAndPage.put("name",selectCategoryName);


        return ListAndPage;
    }

    public Map<String, Object> selcetBookDetail(long no)
    {
        log.info("Service 들어옴");
        BookDTO book = bMapper.selcetBookDetail(no);
        log.info("book : " + book);
        List<FileDTO> file = bMapper.selectFileDetail(no);
        log.info("file : " + file);

        Map<String , Object>m = new HashMap<>();
        m.put("book",book);
        m.put("file",file);



        return m;
    }

    public String insertCart(long bookCode,long userCode)
    {
        CartDTO cart = cartMapper.selectCart(bookCode,userCode);
        String m = "";
        int r = 0;
        if(cart == null)
        {
            r = cartMapper.insertCart(bookCode, userCode);
        }
        else
            r = cartMapper.inneritem(bookCode,userCode,cart);

        if(r == 1)
        {
           m = "장바구니에 상품추가 완료";
        }
        return m;
    }

    public String buyitem(long bookCode, long userCode)
    {
        CartDTO cart = cartMapper.selectCart(bookCode,userCode);
        log.info("b : " + bookCode );
        log.info("u : " + userCode);
        int n = 0;
        String m = "";
        if(cart == null)
        {
            n = cartMapper.insertBuyitem(bookCode,userCode);
        }
        else
        {
            n = cartMapper.upDateItem(bookCode, userCode, cart);
        }

        if(n == 1)
        {
            m = "구매페이지로 이동합니다";
        }
        log.info("m : " + m);
        return m;
    }
}
