package com.javaboy.dd.aspect;

import com.javaboy.dd.annotation.DataSource;
import com.javaboy.dd.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/12 16:02
 */
@Component
@Aspect
@Order(11)
public class DataSourceAspect {

    @Pointcut("@annotation(com.javaboy.dd.annotation.DataSource) || @within(com.javaboy.dd.annotation.DataSource)")
    public void pc() {

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) {
        DataSource dataSource = getDadaSource(pjp);
        if (dataSource != null) {
            String value = dataSource.value();
            DynamicDataSourceContextHolder.setDataSourceType(value);
        }
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }

    private DataSource getDadaSource(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        DataSource annotation = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (annotation != null) {
            return annotation;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
}
