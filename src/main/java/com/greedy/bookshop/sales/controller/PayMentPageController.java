package com.greedy.bookshop.sales.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("web/pay")
public class PayMentPageController
{
    @GetMapping("/payment")
    public void go()
    {}






}
