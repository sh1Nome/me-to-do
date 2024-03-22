package com.example.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class KanbanController {

    @PostMapping("kanban")
    public String showKanban() {
        return "kanban";
    }

}
