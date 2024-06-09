package com.re_kid.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    @GetMapping("top")
    public String getTop() {
        return "top";
    }

}
