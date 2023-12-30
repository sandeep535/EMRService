package com.emr.emrlite.utils;

import org.hibernate.sql.exec.spi.ExecutionContext;

public class EMRSecurityContextHolder {
    private static final ThreadLocal<ExecutionContext> contextHolder = new ThreadLocal<ExecutionContext>();

    public static ExecutionContext getContext() {
        return contextHolder.get();
    }

    public static void setExecutionContext(ExecutionContext context) {

        contextHolder.set(context);
    }

    public static void clearExecutionContext() {
        contextHolder.remove();
    }
}
