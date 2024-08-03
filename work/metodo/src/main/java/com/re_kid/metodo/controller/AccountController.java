package com.re_kid.metodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.re_kid.metodo.form.AccountForm;
import com.re_kid.metodo.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ModelAttribute
    public AccountForm setUpAccountForm() {
        return new AccountForm();
    }

    @GetMapping("account_new")
    public String getAccountNew() {
        return "account_new";
    }

    @PostMapping("account_new")
    public String postAccountNew(@Validated AccountForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "account_new";
        }

        accountService.registerAccount(form.getUsername(), form.getPassword());

        return "redirect:/";
    }

}
