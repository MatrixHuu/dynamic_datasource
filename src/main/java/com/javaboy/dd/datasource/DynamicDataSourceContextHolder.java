package com.javaboy.dd.datasource;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/12 16:03
 */
public class DynamicDataSourceContextHolder {
    private static ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSourceType(String dsType) {
        CONTEXT_HOLDER.set(dsType);
    }

    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }
}
