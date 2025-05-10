//package com.avi.dashBoard.controller;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class CustomErrorController implements ErrorController {
//
//    @GetMapping("/error")
//    public String handleError(HttpServletRequest request, Model model) {
//        System.out.println("Inside error handler controller");
//
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        System.out.println("status>"+status);
//        String errorMessage = "Something went wrong!";
//        int statusCode = 0;
//
//        if (status != null) {
//            statusCode = Integer.parseInt(status.toString());
//            switch (statusCode) {
//                case 400:
//                    errorMessage = "Bad Request (400)!";
//                    break;
//                case 404:
//                    errorMessage = "Page Not Found (404)!";
//                    break;
//                case 500:
//                    errorMessage = "Internal Server Error (500)!";
//                    break;
//                default:
//                    errorMessage = "Unexpected Error (" + statusCode + ")!";
//            }
//        }
//        System.out.println(statusCode+""+errorMessage);
//
//        model.addAttribute("statusCode", statusCode);
//        model.addAttribute("errorMessage", errorMessage);
//        return "error";  // This must match an existing error.html in your templates folder
//    }
//}
