package com.example.metodo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user_setting")
public class UserSetting {

    @Id
    @Column("id")
    private Integer id;

    @Column("user_id")
    private Integer userId;

    @Column("kanban_flg")
    private String kanbanFlg;

}
