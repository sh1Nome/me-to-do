package com.re_kid.metodo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.re_kid.metodo.entity.Account;

import lombok.Getter;

public class AccountUserDetails extends User {

    @Getter
    private final Account acount;

    public AccountUserDetails(Account account, Collection<GrantedAuthority> authorities) {
        super(account.getAccountId(), account.getPassword(), account.getIsEnabled(), true, true, true, authorities);
        this.acount = account;
    }

}
