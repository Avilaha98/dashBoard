//package com.avi.dashBoard.security;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public String handleAllExceptions(Exception ex, HttpServletRequest request,HttpSession session,RedirectAttributes redirectatt) {
//    	System.out.println("inside exception handler"+getRefererPage(request));
////        ModelAndView modelAndView = new ModelAndView(getRefererPage(request));
//        redirectatt.addFlashAttribute("errorMessage", ex.getMessage());
//        return getRefererPage(request);
//    }
//
//    private String getRefererPage(HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        return (referer != null) ? "redirect:" + referer : "error";
//    }
//}
//
