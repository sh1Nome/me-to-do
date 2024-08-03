package com.re_kid.metodo.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class IdUtils {

    private final static SimpleDateFormat sdf;
    static {
        sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    }

    public static enum Prefix {
        AT
    }

    /**
     * IDを生成する
     * 
     * @param prefix
     * @return
     */
    public static String getId(IdUtils.Prefix prefix) {
        Date now = new Date();
        return prefix.toString() + sdf.format(now);
    }
}
