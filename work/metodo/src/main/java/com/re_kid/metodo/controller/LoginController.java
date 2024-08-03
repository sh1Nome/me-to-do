package com.re_kid.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @GetMapping("login")
    public String getLogin(@ModelAttribute("message") String message, Model model) {
        return "login";
    }

}
