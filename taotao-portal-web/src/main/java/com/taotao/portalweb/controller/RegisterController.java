package com.taotao.portalweb.controller;


import com.taotao.portalweb.bean.TbUser;
import com.taotao.portalweb.service.TbUserService;
import com.taotao.portalweb.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.IOException;


@Controller
public class RegisterController extends HttpServlet{
@Autowired
private TbUserService tbUserService;

    @RequestMapping("/register")
    @ResponseBody
    public TaotaoResult register(@RequestBody TbUser tbUser){

       TaotaoResult taotaoResult = tbUserService.register(tbUser);
    return taotaoResult;
    }
@RequestMapping("/activateMail")
@ResponseBody
    public TaotaoResult activateMail(@RequestParam String to){
    TaotaoResult  taotaoResult = tbUserService.activateMail(to);

return taotaoResult;
}
@RequestMapping("/login")
@ResponseBody
    public TaotaoResult login(@RequestParam String username, @RequestParam String password){
        TaotaoResult taotaoResult = tbUserService.login(username,password);



    return taotaoResult;
}
}
