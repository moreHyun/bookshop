package com.greedy.bookshop.sales.service;


import com.greedy.bookshop.sales.model.dao.BookMapper;
import com.greedy.bookshop.sales.model.dto.BookDTO;
import com.greedy.bookshop.sales.model.dto.FileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class InsertBookService
{
    private final BookMapper mapper;

    public InsertBookService(BookMapper mapper)
    {
        this.mapper = mapper;
    }

    public int insertBook(BookDTO book)
    {
            log.info("여긴 서비스입니다.");
            int result = mapper.insertBook(book);

            log.info("서비스에서 나갑니다");
        return result;
    }

    public int insertFile(FileDTO f)
    {
        int result = mapper.insertFile(f);
        return result;
    }
}
