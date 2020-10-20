package com.taotao.portalweb.service;

import com.taotao.portalweb.bean.TbUser;
import com.taotao.portalweb.utils.TaotaoResult;



public interface TbUserService {


    TaotaoResult register(TbUser tbUser);


    TaotaoResult activateMail(String to);

    TaotaoResult login(String username, String password);
}
