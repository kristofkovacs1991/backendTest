package com.bredex.validation;

public interface Validator {
    boolean StringLengthValidator(String data, int maxLength);
    boolean EmailValidator(String email);

}
