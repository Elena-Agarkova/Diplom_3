package org.stellar.burgers.ui.generator;

public class UserGenerator {

    public static String DEFAULT_NAME = "Elena";
    public static String DEFAULT_EMAIL = "testing@test.ru";

    public static String WORKING_EMAIL = "testing@mail.ru";
    public static String DEFAULT_PASSWORD = "pwd123";
    public static String SHORT_PASSWORD = "123";

    public static String getNewRandomEmail() {
        return Math.random() + DEFAULT_EMAIL;
    }
}