package com.re_kid.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @GetMapping("account_new")
    public String getAccountNew() {
        return "account_new";
    }

    @PostMapping("account_new")
    public String postAccountNew() {
        return "redirect:/";
    }

}
