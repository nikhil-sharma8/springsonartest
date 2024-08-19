package com.zemoso.formvalidation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnrollmentNumberConstraintValidator implements ConstraintValidator<EnrollmentNumber, String> {

    private String enrollmentNoPrefix;



    @Override
    public void initialize(EnrollmentNumber constraintAnnotation) {
        enrollmentNoPrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theNumber, ConstraintValidatorContext constraintValidatorContext) {

        if(theNumber == null || theNumber.length()<3)
            return false;

        boolean result = theNumber.substring(0,3).equals(enrollmentNoPrefix);
        return result;
    }
}
