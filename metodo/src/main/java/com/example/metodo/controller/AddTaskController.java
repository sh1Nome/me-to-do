package com.example.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddTaskController {

    @PostMapping("addtask")
    public String showAddTask() {
        return "addtask";
    }

}
