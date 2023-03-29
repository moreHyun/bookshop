package com.greedy.bookshop.common.paging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;

@Slf4j
public class Pagenation
{
    public static PageDTO PageCriteria(int page, int totalCount, int limit, int buttonAmount,String searchtype, String searchValue)
    {
        log.info("searchValue : " + searchValue);
        int maxPage;
        int startPage;
        int endPage;
        PageDTO pageDTO = new PageDTO();
        maxPage = (int) Math.ceil((double) totalCount / limit);
        log.info("maxPage : " + maxPage);
        buttonAmount = maxPage;
        startPage = (int)(Math.ceil((double) page / buttonAmount) - 1) * buttonAmount + 1;
        endPage = startPage + buttonAmount - 1;
        if(maxPage < endPage)
            endPage = maxPage;

        if(maxPage == 0 && endPage == 0)
        {
            maxPage = startPage;
            endPage = startPage;
        }
        if(searchtype == "search")
            pageDTO = new PageDTO(page, totalCount, limit, buttonAmount, maxPage, startPage, endPage, searchtype ,searchValue);
        else
            pageDTO = new PageDTO(page, totalCount, limit, buttonAmount, maxPage, startPage, endPage, searchtype ,searchValue);

        return pageDTO;
    }
}
