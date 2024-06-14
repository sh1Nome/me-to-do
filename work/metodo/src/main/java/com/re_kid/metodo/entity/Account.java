package com.re_kid.metodo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    private String accountId;

    private String password;

    private String isEnabled;

    private Date createDate;

    private Date updateData;

}
