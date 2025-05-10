//package com.avi.dashBoard.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.security.web.context.SecurityContextRepository;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//
//import com.avi.dashBoard.service.SessionService;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import jakarta.servlet.http.HttpSession;
//import java.util.List;
//import org.springframework.security.core.session.SessionInformation;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.core.session.SessionRegistryImpl;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, SessionService SessionService) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/register","/error","/login","/dashboard", "/css/**", "/js/**", "/images/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .successHandler(authenticationSuccessHandler(SessionService))
////                .failureHandler((request, response, exception) -> {
////                    // Pass error message in URL
////                    response.sendRedirect(request.getContextPath() +"/error?code=401&message=" + exception.getMessage());
////                })
//            )
//            .logout(logout -> logout
//                .logoutUrl("/logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/login?logout=true")
//                .permitAll()
//            )
//            .sessionManagement(session -> session
//                .sessionFixation(sessionFixation -> sessionFixation.migrateSession()) 
//                .maximumSessions(1)
//                .expiredUrl("/login?expired=true")
//                .sessionRegistry(sessionRegistry())
//            )
//            .securityContext(securityContext -> securityContext
//                .securityContextRepository(securityContextRepository())
//            )
//            .csrf(csrf -> csrf.disable())  // Disable CSRF if using REST APIs
//            .anonymous(anonymous -> anonymous.disable()).addFilterBefore(new SessionValidationFilter(SessionService), UsernamePasswordAuthenticationFilter.class);
// 
//
//        return http.build();
//    }
//
//    @Bean
//    public SecurityContextRepository securityContextRepository() {
//        return new HttpSessionSecurityContextRepository();
//    }
//
//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler(SessionService userSessionService) {
//        return (request, response, authentication) -> {
//            String username = authentication.getName();
//            String sessionId = request.getSession().getId();
//
//            // Store or update session ID
//            userSessionService.saveOrUpdateSession(username, sessionId);
//
//            response.sendRedirect(request.getContextPath() + "/dashboard");
//        };
//    
//    }
//}
