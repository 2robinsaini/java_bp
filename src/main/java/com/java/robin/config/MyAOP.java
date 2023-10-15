package com.java.robin.config;

import com.java.robin.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOP {

    private Logger logger = LoggerFactory.getLogger(MyAOP.class);

    @Before(value = "execution(* com.java.robin.controller.StudentController.*(..)) and args(student)")
    public void beforeAdvice(JoinPoint joinPoint, Student student) {
        logger.info("Before method:" + joinPoint.getSignature());
        logger.info("Adding student with name - " + student.getStdName());
    }


    @After(value = "execution(* com.java.robin.controller.StudentController.*(..)) and args(rollNumber)")
    public void afterAdvice(JoinPoint joinPoint, Long rollNumber) {
        logger.info("After method:" + joinPoint.getSignature());
        logger.info("Removing student of roll number - " + rollNumber);
    }

    @AfterReturning(value = "execution(* com.java.robin.controller.StudentController.*(..)) and args(rollNumber)")
    public void afterReturningAdvice(JoinPoint joinPoint, Long rollNumber) {
        logger.info("After Returning method:" + joinPoint.getSignature());
        logger.info("After Returning Removing student of roll number - " + rollNumber);
    }

    @AfterThrowing(value = "execution(* com.java.robin.controller.StudentController.*(..)) and args(rollNumber)")
    public void afterThrowingAdvice(JoinPoint joinPoint, Long rollNumber) {
        logger.info("After Throwing method:" + joinPoint.getSignature());
        logger.info("After Throwing Removing student of roll number - " + rollNumber);
    }

    @Pointcut(value= "execution(* com.java.robin.controller.StudentController.*(..))")
    private void getStudents()
    {
        System.out.println("in point cut method");
    }

    @Around(value= "getStudents()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        logger.info("The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
        Object data = null;
        try
        {
            logger.info("just before...");
            data = jp.proceed();
            logger.info("just after...");
        }
        finally
        {
            logger.info("The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");
            return data;
        }

    }
}


