package com.greedy.bookshop.sales.model.dao;


import com.greedy.bookshop.common.paging.PageDTO;
import com.greedy.bookshop.sales.model.dto.BookDTO;
import com.greedy.bookshop.sales.model.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BookMapper
{
    int insertBook(BookDTO b);

    int insertFile(FileDTO f);

    List<BookDTO> selcetAllBook();

    List<FileDTO> selcetAllFile();

    List<BookDTO> selectBookCategory(long c);

    List<FileDTO> selectFileCategory(long b);

    List<BookDTO> selcetBookList(PageDTO p);

    int selectTotalCount(Map<String, String> s);

    List<FileDTO> searchFile(long bookCode);

    BookDTO selcetBookDetail(long no);

    List<FileDTO> selectFileDetail(long no);
}
