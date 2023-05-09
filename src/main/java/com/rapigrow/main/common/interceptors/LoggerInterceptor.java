package com.rapigrow.main.common.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerInterceptor {
    @Pointcut("@annotation(com.rapigrow.main.common.interceptors.Logged)")
    public void annotatedMethod() {
    }

    @Pointcut("@within(com.rapigrow.main.common.interceptors.Logged)")
    public void annotatedClass() {
    }

    @Before("execution(* *(..)) && (annotatedMethod() || annotatedClass())")
    public void log(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}
