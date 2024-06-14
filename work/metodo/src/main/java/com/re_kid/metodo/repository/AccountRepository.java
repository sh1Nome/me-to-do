package com.re_kid.metodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re_kid.metodo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
