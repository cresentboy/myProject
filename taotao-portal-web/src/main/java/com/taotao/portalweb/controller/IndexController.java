package com.taotao.portalweb.controller;

import com.taotao.portalweb.constant.ContentConstant;
import com.taotao.portalweb.service.ContentService;
import com.taotao.portalweb.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */

@Controller
public class IndexController {
    @Autowired
    private ContentService contentService;

    @RequestMapping("/showContent")
    @ResponseBody
    public TaotaoResult showContent(){
        TaotaoResult result = contentService.findContentByCId(ContentConstant.BIGAD);
        return result;
    }
    //http://localhost:8081/index
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
