package com.re_kid.metodo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    private String accountId;

    private String password;

    private Boolean isEnabled;

    private Date createDate;

    private Date updateDate;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Authorities> authorities;

}
