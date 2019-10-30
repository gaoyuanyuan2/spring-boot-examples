package com.yan.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Created by yan on  27/09/2018.
 */
public class CardNumberValidator implements ConstraintValidator<ValidCardNumber, String>
{

    private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public void initialize(ValidCardNumber validCardNumber) {
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value==null ? false: pattern.matcher(value).matches();
    }
}
