package org.fundacionjala.trello.core.utils;

public class IdGenerator {
    public static String getUniqueId() {
        String id = "-" + Math.random();
        return id;
    }
}
