package com.example.metodo.aop;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.example.metodo..*.*(..))")
    public void startLog(JoinPoint joinPoint) {
        this.outMethodName("開始", joinPoint);
    }

    @AfterReturning(
        pointcut = "execution(* com.example.metodo..*.*(..))", 
        returning = "retVal")
    public void returnLog(JoinPoint joinPoint, Object retVal) {

        this.outMethodName("正常終了", joinPoint);
        this.outMethodArgs(joinPoint);
        if (Objects.nonNull(retVal)) {
            System.out.println("戻り値：" + retVal);
        }

    }

    @AfterThrowing(
        pointcut = "execution(* com.example.metodo..*.*(..))", 
        throwing = "e")
    public void throwLog(JoinPoint joinPoint, Exception e) {
        this.outMethodName("異常終了", joinPoint);
        e.printStackTrace();
    }

    private void outMethodName(String status, JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        System.out.println("---" + status + "---：" + declaringTypeName + "." + name);
    }

    private void outMethodArgs(JoinPoint joinPoint) {
        String[] argsName = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] argsValue = joinPoint.getArgs();
        if (argsName.length == argsValue.length && 0 < argsValue.length) {
            System.out.println("引数：");
            for (int i = 0; i < argsValue.length; i++) {
                System.out.println(argsName[i] + " = " + argsValue[i]);
            }
        }
    }

}
