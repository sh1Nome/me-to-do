package com.re_kid.metodo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "authority.db")
@Data
public class AuthorityDbProperties {

    private String admin;

}
