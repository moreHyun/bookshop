package com.greedy.bookshop.sales.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO
{
    private long cartCode;
    private long bookQuantity;
    private long bookCode;
    private String itemStatus;
    private long userCode;

}
