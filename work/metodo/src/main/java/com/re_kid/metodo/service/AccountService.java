package com.re_kid.metodo.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.re_kid.metodo.entity.Account;
import com.re_kid.metodo.entity.Authorities;
import com.re_kid.metodo.repository.AccountRepository;
import com.re_kid.metodo.util.IdUtils;
import com.re_kid.metodo.util.RoleUtils;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerAccount(String username, String password) {
        Date now = new Date();

        // アカウントEntity
        Account account = new Account();
        account.setAccountId(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setIsEnabled(true);
        account.setCreateDate(now);
        account.setUpdateDate(now);

        // 権限Entity
        Authorities authorities = new Authorities();
        authorities.setAuthoritiesId(IdUtils.getId(IdUtils.Prefix.AT));
        authorities.setAuthority(RoleUtils.getUser());
        authorities.setUpdateDate(now);

        // 関係
        authorities.setAccount(account);
        account.setAuthorities(List.of(authorities));

        // DB更新
        accountRepository.save(account);
    }

}
