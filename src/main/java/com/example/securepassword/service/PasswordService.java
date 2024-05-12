package com.example.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePass(String pass){
        List<String> failures = new ArrayList<>();

        validateLength(pass, failures);
        validateUpperCase(pass, failures);
        validateLowerCase(pass, failures);
        validateNumber(pass, failures);
        validateSpecialCharacter(pass, failures);

        return failures;
    }

    private void validateLength(String pass, List<String> failures) {
        if(pass.length() < 8){
            failures.add("Password must have more than 8 digits.");
        }
    }

    private void validateUpperCase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[A-Z].*", pass)){
            failures.add("Password must have at least 1 uppercase letter.");
        }
    }

    private void validateLowerCase(String pass, List<String> failures) {
        if(!Pattern.matches(".*[a-z].*", pass)){
            failures.add("Password must have at least 1 lowercase letter.");
        }
    }

    private void validateNumber(String pass, List<String> failures) {
        if(!Pattern.matches(".*\\d.*", pass)){
            failures.add("Password must have at least 1 number.");
        }
    }

    private void validateSpecialCharacter(String pass, List<String> failures) {
        if(!Pattern.matches(".*[^a-zA-Z0-9].*", pass)){
            failures.add("Password must have at least 1 special character.");
        }
    }


}
