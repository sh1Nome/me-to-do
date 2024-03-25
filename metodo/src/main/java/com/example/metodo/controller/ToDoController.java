package com.example.metodo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.metodo.form.UserSettingForm;
import com.example.metodo.service.ChangeUserSetting;
import com.example.metodo.service.CheckUserSetting;

@Controller
public class ToDoController {

    @Autowired
    CheckUserSetting checkUserSetting;

    @Autowired
    ChangeUserSetting changeUserSetting;

    @PostMapping("todo")
    public String postMethodName(UserSettingForm userSettingForm, Model model) throws Exception {
 
        String changeView = userSettingForm.getChangeView();
        if (Objects.nonNull(changeView)) {
            changeUserSetting.changeKanbanFlg(1);
        }

        String showView = "list";
        String kanbanFlg = checkUserSetting.checkKanbanFlg(1);
        if (kanbanFlg.equals("Y")) {
            showView = "kanban";
        }

        return showView;

    }

}
