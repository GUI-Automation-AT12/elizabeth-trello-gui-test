package org.fundacionjala.trello.ui.utils;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.fundacionjala.trello.ui.config.Environment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class PageTransporter {

    private static final HashMap<String, String> PAGE_URL = new HashMap<>();

    private PageTransporter() {

    }

    static {
        PAGE_URL.put("LOGIN", "login");
        PAGE_URL.put("MY PROFILE", "eliza7890");
        PAGE_URL.put("BOARDS", "eliza7890/boards");
    }

    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(Environment.getInstance().getBaseUrl().concat("/" + PAGE_URL.get(pageName.toUpperCase())));
    }

    public static void navigateToPage() throws MalformedURLException {
        navigateToUrl(Environment.getInstance().getBaseUrl());
    }

    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }
}
