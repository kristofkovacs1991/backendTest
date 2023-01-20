package com.bredex.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidatorImpl implements Validator{


    @Override
    public boolean StringLengthValidator(String data, int maxlength) {
        if(data.length() <= maxlength){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean EmailValidator(String email) {

        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
