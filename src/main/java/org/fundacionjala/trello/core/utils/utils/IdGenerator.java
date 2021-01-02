package org.fundacionjala.trello.core.utils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {

    public static String getUniqueId() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        return  formatter.format(date);
    }
}
