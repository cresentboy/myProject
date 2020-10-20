package com.taotao.portalweb.controller;

import com.taotao.portalweb.service.TbItemCatService;
import com.taotao.portalweb.vo.ItemCatNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemCat")
public class TbItemCatController {
    @Autowired
    private TbItemCatService tbItemCatService;

    @RequestMapping("/queryItemCat")
    private List<ItemCatNode> queryItemCat(Long id){
        List<ItemCatNode> nodes = tbItemCatService.findItemCatById(id);
        return nodes;
    }

}
