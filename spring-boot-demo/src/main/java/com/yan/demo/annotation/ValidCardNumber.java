package com.yan.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by yan on  27/09/2018.
 * 自定义验证
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {CardNumberValidator.class})
public @interface ValidCardNumber {

    String message() default "手机号格式不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
