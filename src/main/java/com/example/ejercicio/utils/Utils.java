package com.example.ejercicio.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    @Value("${pattern.password.regexp}")
    String patternPass;

    @Value("${pattern.email.regexp}")
    String patternEmail;

    public Boolean validatePassword(String pass){
        return pass.matches(patternPass);
    }

    public Boolean validateEmail(String email){
        return email.matches(patternEmail);
    }
}
