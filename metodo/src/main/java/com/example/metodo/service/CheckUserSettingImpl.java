package com.example.metodo.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.metodo.entity.UserSetting;
import com.example.metodo.repository.UserSettingCrudRepository;

@Service
public class CheckUserSettingImpl implements CheckUserSetting {

    @Autowired
    UserSettingCrudRepository repository;

    String kanbanFlg = null;
    
    @Override
    public String checkKanbanFlg(Integer id) throws Exception {
        Optional<UserSetting> entity = repository.findById(id);
        entity.ifPresent((userSetting) -> {
            kanbanFlg = userSetting.getKanbanFlg();
        });
        if (Objects.isNull(kanbanFlg)) {
            throw new Exception();
        }
        return kanbanFlg;
    }
    
}
