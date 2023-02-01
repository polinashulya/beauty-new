package com.company.service.dto.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final String PHONE_PATTER = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";

    private static final Pattern PATTERN = Pattern.compile(PHONE_PATTER);

    @Override
    public boolean isValid(final String phoneNumber, final ConstraintValidatorContext context) {
        if (Objects.nonNull(phoneNumber)) {
            return validatePhone(phoneNumber);
        } else {
            return false;
        }
    }

    private boolean validatePhone(final String phoneNumber) {
        Matcher matcher = PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }

}
