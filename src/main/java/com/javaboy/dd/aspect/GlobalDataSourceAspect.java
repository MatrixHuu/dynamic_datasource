package com.javaboy.dd.aspect;

import com.javaboy.dd.datasource.DataSourceType;
import com.javaboy.dd.datasource.DynamicDataSourceContextHolder;
import org.aspectj.apache.bcel.generic.RET;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/13 20:15
 */

@Aspect
@Component
@Order(10)
public class GlobalDataSourceAspect {

    @Autowired
    HttpSession httpSession;

    @Pointcut("execution(* com.javaboy.dd.service.*.*(..))")
    public void pc() {
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) {
        DynamicDataSourceContextHolder.setDataSourceType((String) httpSession.getAttribute(DataSourceType.DS_SESSION_KEY));
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }
}
