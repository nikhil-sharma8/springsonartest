package com.zemoso.formvalidation.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderConstraintValidator implements ConstraintValidator<Gender, Character> {
    @Override
    public void initialize(Gender constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Character gender, ConstraintValidatorContext constraintValidatorContext) {

        boolean result = false;

        if(gender == null)
            return false;

        result = gender == 'M' || gender == 'F';

        return result;
    }

}
