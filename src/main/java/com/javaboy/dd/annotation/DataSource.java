package com.javaboy.dd.annotation;

import com.javaboy.dd.datasource.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/12 16:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DataSource {
    String value() default DataSourceType.DEFAULT_DS_NAME;
}

