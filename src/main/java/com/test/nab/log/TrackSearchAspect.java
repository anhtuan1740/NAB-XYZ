package com.test.nab.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackSearchAspect {

    @After("execution(* com.test.nab.repository.impl.ProductCustomRepositoryImpl.findByNameColorSize(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Starting save search data");
        System.out.println(joinPoint.getArgs());
    }
}
