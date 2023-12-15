//package com.emr.emrlite.filters;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.MDC;
//import org.springframework.http.HttpStatus;
//
//import java.io.IOException;
//
//public class EMRSecurityFilter implements Filter {
//
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers",
//                "origin,x-requested-with,content-type,x-auth-token,x-action-ref,x-person-id,x-ipaddress,x-doctorvisit-id,x-facility-id,x-portal,x-locale,x-timezone,x-tenantId,x-mode");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Content-Type", "application/json;charset=UTF-8");
//        HttpServletRequest request = (HttpServletRequest) req;
//        String method = request.getMethod();
//        try {
//            if ("OPTIONS".equals(method)) {
//                response.setStatus(HttpStatus.OK.value());
//            } else {
//                MDC.put("tenantId", "TenantId: " + request.getHeader("x-tenantId"));
//                chain.doFilter(req, res);
//            }
//        } finally {
//            MDC.remove("tenantId");
//        }
//    }
//
//    public void init(FilterConfig filterConfig) {
//    }
//
//    public void destroy() {
//    }
//
//}
//
