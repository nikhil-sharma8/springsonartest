package com.zemoso.formvalidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GenderConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Gender {

    public char value() default 'M';

    public String message() default "must be either F or M";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
