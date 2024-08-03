package com.re_kid.metodo.util;

public class RoleUtils {

    private static enum Role {
        ROLE_ADMIN,
        ROLE_USER
    }

    public static String getAdmin() {
        return RoleUtils.Role.ROLE_ADMIN.toString();
    }

    public static String getUser() {
        return RoleUtils.Role.ROLE_USER.toString();
    }

}
