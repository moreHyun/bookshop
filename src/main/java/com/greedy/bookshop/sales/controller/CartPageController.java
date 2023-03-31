package com.greedy.bookshop.sales.controller;

import com.greedy.bookshop.sales.model.dto.CartDTO;
import com.greedy.bookshop.sales.model.dto.UserDTO;
import com.greedy.bookshop.sales.service.CartPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String showCartList(Model model)
    {
        UserDTO user = new UserDTO();
        user.setUserCode(1);
        Map<String, Object> cart = cartPageService.selectUserCart(user.getUserCode());
        model.addAttribute("user",user);
        model.addAttribute("cart",cart.get("cart"));
        model.addAttribute("book",cart.get("book"));
        model.addAttribute("file",cart.get("file"));

        for(int i = 0; i < cart.size(); i++)
        {
            log.info("Controller] model " + i + " : " + model);
        }

        return "/cart/cart";
    }

    @PostMapping("/update")
    public ResponseEntity<String> buyItem(@RequestBody List<String> cartCode)
    {
        String m = "";
        for(String c : cartCode)
            m = cartPageService.UpdateStatus(Long.valueOf(c),1);

        return ResponseEntity.ok(m);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteItem(@RequestBody List<String> cartCode)
    {
        String m = "";
        for(String c : cartCode)
            cartPageService.deleteItem(Long.valueOf(c),1);
        return ResponseEntity.ok(m);
    }




}
