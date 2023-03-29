package com.greedy.bookshop.sales.model.dao;


import com.greedy.bookshop.sales.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper
{
    List<CategoryDTO> selcetAllCategory();

    String selectTopCategoryName(long categoryCode);

    String selectSubCategoryName(long categoryCode);
}
