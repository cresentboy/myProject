package com.taotao.portalweb.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler{

    @ExceptionHandler(Exception.class)
    public String customException(Exception e, Model model){
        model.addAttribute("error","报错了联系管理员");
        System.out.println("aaaaaaa");
        return "error";
    }
}
