package org.fundacionjala.trello;

public class App {
    /**
     * Gets greeting.
     * @return greeting
     */
    public String getGreeting() {
        return "Hello world.";
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println(new App().getGreeting());
    }
}
