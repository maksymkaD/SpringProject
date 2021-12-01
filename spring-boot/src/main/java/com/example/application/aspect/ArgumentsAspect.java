package com.example.application.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class ArgumentsAspect {
    public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Around("@annotation(com.example.application.aspect.LogArguments)")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Object result = proceedingJoinPoint.proceed();
        Object[] methodArgumets = proceedingJoinPoint.getArgs();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();


        for (Object methodArgument : methodArgumets)
        {
            if (logger.isInfoEnabled()) {
                logger.info("Class: " + className + " -> Method: " + methodName + " -> Argument:" + methodArgument );
            }
        }


        return result;



    }
}


