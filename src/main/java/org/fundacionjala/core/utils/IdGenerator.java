package org.fundacionjala.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class IdGenerator {

    private IdGenerator() {
    }

    /**
     * Gets a string with formatted date.
     * @return uniqueId
     */
    public static String getUniqueId() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        return  formatter.format(date);
    }
}
