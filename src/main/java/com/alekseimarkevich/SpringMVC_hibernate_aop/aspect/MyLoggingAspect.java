package com.alekseimarkevich.SpringMVC_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.alekseimarkevich.SpringMVC_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("___________________________________________________");
        System.out.println("Begin of " + methodName);
        Object targetMethodResult = pjp.proceed();
        System.out.println("End of " + methodName);
        System.out.println("___________________________________________________");

        return targetMethodResult;
    }

}
