package com.re_kid.metodo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.re_kid.metodo.entity.Account;
import com.re_kid.metodo.entity.Authorities;
import com.re_kid.metodo.property.MetodoAuthority;
import com.re_kid.metodo.property.MetodoUser;
import com.re_kid.metodo.repository.AccountRepository;

@Service
public class MetodoApplicationService {

    private final AccountRepository accountRepository;

    private final MetodoUser meToDoUser;

    private final MetodoAuthority metodoAuthority;

    private final PasswordEncoder passwordEncoder;

    public MetodoApplicationService(AccountRepository accountRepository,
            MetodoUser meToDoUser,
            MetodoAuthority metodoAuthority, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.meToDoUser = meToDoUser;
        this.metodoAuthority = metodoAuthority;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 起動時の初期ユーザー投入処理
     * 
     * @return
     */
    @Transactional
    public void initMetodoUser() {
        Date now = new Date();
        String metodoUserName = meToDoUser.getName();
        String metodoUserPassword = passwordEncoder.encode(meToDoUser.getPassword());

        Account account = accountRepository.findById(metodoUserName).orElse(new Account());

        Optional.ofNullable(account.getAccountId()).ifPresentOrElse(accountId -> {
            account.setPassword(metodoUserPassword);
            account.setUpdateDate(now);
        }, () -> {
            account.setAccountId(metodoUserName);
            Authorities authorities = new Authorities();
            authorities.setAccount(account);
            authorities.setAuthoritiesId(meToDoUser.getAuthorityId());
            authorities.setAuthority(metodoAuthority.getAdmin());
            authorities.setUpdateDate(now);
            account.setAuthorities(List.of(authorities));
            account.setCreateDate(now);
            account.setIsEnabled(true);
            account.setPassword(metodoUserPassword);
            account.setUpdateDate(now);
            accountRepository.save(account);
        });

    }

}
