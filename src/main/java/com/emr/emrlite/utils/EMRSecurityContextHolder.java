package com.emr.emrlite.utils;

public class EMRSecurityContextHolder {
    private static final ThreadLocal<com.emr.emrlite.utils.ExecutionContext> contextHolder = new ThreadLocal<com.emr.emrlite.utils.ExecutionContext>();

    public static com.emr.emrlite.utils.ExecutionContext getContext() {
        return contextHolder.get();
    }

    public static void setExecutionContext(ExecutionContext context) {

        contextHolder.set(context);
    }

    public static void clearExecutionContext() {
        contextHolder.remove();
    }


}
