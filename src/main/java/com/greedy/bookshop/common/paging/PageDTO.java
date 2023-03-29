package com.greedy.bookshop.common.paging;

import lombok.*;

import java.lang.ref.PhantomReference;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageDTO
{
    private int page;
    private int totalCount;
    private int limit;
    private int buttonAmount;
    private int maxPage;
    private int startPage;
    private int endPage;
    private String searchType;
    private String searchValue;
}
