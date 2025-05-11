//package com.avi.dashBoard.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.avi.dashBoard.entity.User;
//import com.avi.dashBoard.service.UserService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Controller
//public class RegisterControler {
//	@Autowired
//	UserService userService;
//    @GetMapping("/register")
//    public String showRegistrationForm() {
//        return "register";
//    }
//    @PostMapping("/register")
//    public String RegistrationForm(User user) {
//    	//try {
//    	if(user.getUsername().equalsIgnoreCase("b"))
//    		throw new RuntimeException("failed");
//    	else
//    	userService.registerUser(user);
//    	//}catch(Exception e) {
//    		//e.getMessage();
//    	//	System.out.println(e.getMessage());
//    	//}
//        return "login";
//    }
////
////    @GetMapping("/login")
////    public String showLoginForm() {
////        return "login";  // Spring Security will handle authentication
////    }
////
////    @GetMapping("/dashboard")
////    public String showDashboard(Model model) {
////        return "dashboard";
////    }
////    @GetMapping("/logout")
////    public String logout(HttpServletRequest request, HttpServletResponse response) {
////        System.out.println("Logging out user: " + SecurityContextHolder.getContext().getAuthentication().getName());
////       boolean a=true;
////        if(a) {
////        	throw new RuntimeException("failed");
////        }
////        else {
////        request.getSession().invalidate();  
////        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
////        
////        System.out.println("Session invalidated. Redirecting to login.");
////        }
////        return "redirect:/login?logout"; 
////    }
//
//
//}
