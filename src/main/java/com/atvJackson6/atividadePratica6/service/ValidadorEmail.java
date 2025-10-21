package com.atvJackson6.atividadePratica6.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEmail {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private Pattern pattern;

    public ValidadorEmail() {
        this.pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean isValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

