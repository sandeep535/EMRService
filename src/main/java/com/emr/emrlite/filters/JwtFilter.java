package com.emr.emrlite.filters;

import com.emr.emrlite.interceptor.TenantContext;
import com.emr.emrlite.service.AppUserDetailsService;
import com.emr.emrlite.service.TokenBlacklistService;
import com.emr.emrlite.utils.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AppUserDetailsService service;

    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String tenantID = httpServletRequest.getHeader("X-TenantID");

        TenantContext.setCurrentTenant(tenantID);

        String token = null;
        String userName = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);

            // Check 1 — token was explicitly logged out
            if (tokenBlacklistService.isBlacklisted(token)) {
                sendErrorResponse(httpServletResponse, HttpServletResponse.SC_UNAUTHORIZED, "Token has been invalidated. Please login again.");
                return;
            }

            // Check 2 — token is expired
            try {
                userName = jwtUtil.extractUsername(token);
            } catch (ExpiredJwtException e) {
                sendErrorResponse(httpServletResponse, HttpServletResponse.SC_UNAUTHORIZED, "Token has expired. Please login again.");
                return;
            } catch (Exception e) {
                sendErrorResponse(httpServletResponse, HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
                return;
            }
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = service.loadUserByUsername(userName);
            if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void sendErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write("{\"error\": \"" + message + "\"}");
        response.getWriter().flush();
    }
}