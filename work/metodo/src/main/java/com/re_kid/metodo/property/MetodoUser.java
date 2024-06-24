package com.re_kid.metodo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "metodo.user")
@Data
public class MetodoUser {

    private String name;

    private String password;

    private String authorityId;

}
