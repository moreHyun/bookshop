package com.greedy.bookshop.sales.controller;

import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.model.dto.PayDTO;
import com.greedy.bookshop.sales.service.PayService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/pay")
public class PayController
{
    private final PayService payService;

    public PayController(PayService payService)
    {
        this.payService = payService;
    }

    @PostMapping("/payment")
    public RedirectView payment(@RequestBody long bookCode)
    {
        log.info("bookCode" + bookCode);
        List<PayDTO> cart = payService.getCartitem(bookCode);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/pay/payment");
       return redirectView;
    }













}
