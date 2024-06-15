package com.re_kid.metodo.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.re_kid.metodo.entity.Account;
import com.re_kid.metodo.property.AuthorityDbProperties;
import com.re_kid.metodo.property.AuthoritySpringSecurityProperties;
import com.re_kid.metodo.repository.AccountRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final AuthorityDbProperties authorityDbProperties;

    private final AuthoritySpringSecurityProperties authoritySpringSecurityProperties;

    public AccountUserDetailsService(AccountRepository accountRepository, AuthorityDbProperties authorityDbProperties,
            AuthoritySpringSecurityProperties authoritySpringSecurityProperties) {
        this.accountRepository = accountRepository;
        this.authorityDbProperties = authorityDbProperties;
        this.authoritySpringSecurityProperties = authoritySpringSecurityProperties;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new AccountUserDetails(account, getAuthorities(account));
    }

    private Collection<GrantedAuthority> getAuthorities(Account account) {
        return AuthorityUtils.createAuthorityList(account.getAuthorities().stream()
                .map(authorityes -> authorityes.getAuthority())
                .map(auth -> authorityDbProperties.getAdmin().equals(auth)
                        ? authoritySpringSecurityProperties.getAdmin()
                        : auth)
                .distinct().collect(Collectors.toList()));
    }

}
