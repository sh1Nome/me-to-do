package com.re_kid.metodo.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.re_kid.metodo.form.AccountForm;
import com.re_kid.metodo.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;

    private final MessageSource messageSource;

    public AccountController(AccountService accountService, MessageSource messageSource) {
        this.accountService = accountService;
        this.messageSource = messageSource;
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
    public String postAccountNew(@Validated AccountForm form, BindingResult result,
            RedirectAttributes redirectAttributes, Locale locale,
            UriComponentsBuilder ucb) {
        if (result.hasErrors()) {
            return "account_new";
        }

        accountService.registerAccount(form.getUsername(), form.getPassword());

        redirectAttributes.addFlashAttribute("message",
                messageSource.getMessage("success.account.register", null, locale));

        return "redirect:" + ucb.path("/login").build().toUri().toString();
    }

}
