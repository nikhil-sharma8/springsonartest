package com.zemoso.formvalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EnrollmentNumberConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnrollmentNumber {

    public String value() default "ZEM";

    public String message() default "must start with ZEM";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
