package com.yangyh.aop;

import com.yangyh.annotation.Validate;
import com.yangyh.entity.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yangyh
 * @create: 2018-12-13 21:18
 **/

@Aspect
@Component
public class CheckAspect {

    @Pointcut("@annotation(com.yangyh.entity.User)")
    private void validateAspect(){}

    @Before(value = "validateAspect()&&@annotation(validate)", argNames = "validate")
    public void check(Validate validate) {
        validate.isNotNull();

    }



}
