//package com.avi.dashBoard.controller;
//
//import com.avi.dashBoard.service.SessionService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//@Component
//public class SessionInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private SessionService sessionService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//     System.out.println("inside interceptor");
//  // Exclude login and register pages from session validation
//     String requestURI = request.getRequestURI();
//
//     if (requestURI.equals("/login") || requestURI.equals("/dashboard") || requestURI.startsWith("/css") || requestURI.startsWith("/js") || requestURI.startsWith("/images")) {
//         return true; // Allow without checking session
//     }
//
//     System.out.println("inside interceptor: " + requestURI);
//
//     String sessionId = request.getSession().getId();
//     if (!sessionService.isSessionValid(sessionId)) {
//         SecurityContextHolder.clearContext();
//         response.sendRedirect("/login?sessionExpired=true");
//         return false;
//     }
//     return true;
//    }
//}
