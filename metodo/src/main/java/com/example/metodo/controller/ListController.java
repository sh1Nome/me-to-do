package com.example.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListController {

    @PostMapping("list")
    public String showList() {
        return "list";
    }

}
