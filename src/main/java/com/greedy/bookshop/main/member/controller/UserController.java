package com.greedy.bookshop.main.member.controller;

import com.greedy.bookshop.main.member.dto.UserDTO;
import com.greedy.bookshop.main.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(String id, String password, Model model) {
        UserDTO user = userService.getUserById(id);

        if (user == null) {
            model.addAttribute("errorMessage", "아이디가 존재하지 않습니다.");
            return "login";
        }

        if (!user.getPassword().equals(password)) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "login";
        }

        model.addAttribute("user", user);
        return "index";
    }
}
