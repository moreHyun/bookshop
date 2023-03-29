package com.greedy.bookshop.sales.controller;

import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.service.CartPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/cart")
public class CartPageController
{
    private final CartPageService cartPageService;

    public CartPageController(CartPageService cartPageService)
    {
        this.cartPageService = cartPageService;
    }

    @GetMapping("/cart")
    public void go() { }

    @PostMapping("/regist")
    public String cartRegist(@RequestParam long bookCode, Model model)
    {
        log.info("CartController] bookCode : " + bookCode);
        int r = cartPageService.insertCart(bookCode,1);

        if(r == 1)
        {
            model.addAttribute("message","장바구니에 상품추가 완료");
        }

        return "redirect:/sale/bookDetails?no=" + bookCode;
    }


}
