//package com.avi.dashBoard.security;
//
//import com.avi.dashBoard.service.SessionService;
//import com.avi.dashBoard.entity.User;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.io.IOException;
//import java.util.Optional;
//
//public class SessionValidationFilter extends GenericFilterBean {
//
//    private final SessionService userSessionService;
//
//    public SessionValidationFilter(SessionService userSessionService) {
//        this.userSessionService = userSessionService;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//			System.out.println("inside do filter");
//			HttpServletResponse httpResponse = (HttpServletResponse) response; // Cast to HttpServletResponse
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpSession session = httpRequest.getSession(false);
//
//        if (session != null) {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//            if (authentication != null && authentication.isAuthenticated()) {
//                String username = authentication.getName();
//                Optional<User> userSessionOpt = userSessionService.getUserSession(username);
//
//                if (userSessionOpt.isPresent()) {
//                    User userSession = userSessionOpt.get();
//System.out.println("session.getId()>>"+session.getId()+"userSession.getSessionId()>>"+userSession.getSessionId());
//                    if (!session.getId().equals(userSession.getSessionId())) {
//                        session.invalidate(); // Invalidate old session
//                        SecurityContextHolder.clearContext(); // Logout user
//                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/login?expired=true");
//
//                        return;
//                    }
//                }
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}
