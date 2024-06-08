package com.example.metodo.controller;

import java.net.URI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Controller
public class LogoutController {

    @PostMapping("logout")
    public String logoutProcess() {
        UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(LoginController.class, "showLogin").build();
        URI location = uriComponents.toUri();
        return "redirect:" + location.toString();
    }

}
