package com.re_kid.metodo.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountForm {

    @Size(max = 60)
    private String username;

    private String password;

}
