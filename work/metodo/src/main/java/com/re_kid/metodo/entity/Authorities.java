package com.re_kid.metodo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Authorities {

    @Id
    private String authoritiesId;

    private String authority;

    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
