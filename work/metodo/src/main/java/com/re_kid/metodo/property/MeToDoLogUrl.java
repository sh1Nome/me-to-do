package com.re_kid.metodo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "metodo.log.url")
@Data
public class MetodoLogUrl {

    private String app;

    private String adminer;

}
