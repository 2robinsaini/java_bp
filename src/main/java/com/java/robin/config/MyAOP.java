package com.java.robin.config;

import com.java.robin.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class MyAOP {

    private Logger logger = LoggerFactory.getLogger(MyAOP.class);

    @Before(value = "execution(* com.java.robin.controller.StudentController.*(..)) and args(student)")
    public void beforeAdvice(JoinPoint joinPoint, Student student) {
        logger.info("Before method:" + joinPoint.getSignature());
        logger.info("Adding student with name - " + student.getStdName());
    }

}
