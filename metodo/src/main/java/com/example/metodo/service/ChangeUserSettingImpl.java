package com.example.metodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.metodo.entity.UserSetting;
import com.example.metodo.repository.UserSettingCrudRepository;

@Service
public class ChangeUserSettingImpl implements ChangeUserSetting {

    @Autowired
    UserSettingCrudRepository repository;

    @Autowired
    CheckUserSetting checkUserSetting;

    @Override
    public void changeKanbanFlg(Integer id) throws Exception {
        String kanbanFlg = checkUserSetting.checkKanbanFlg(id);
        if (kanbanFlg.equals("Y")) {
            kanbanFlg = "N";
        } else {
            kanbanFlg = "Y";
        }
        UserSetting userSetting = new UserSetting(id, 1, kanbanFlg);
        repository.save(userSetting);
    }
    
}
