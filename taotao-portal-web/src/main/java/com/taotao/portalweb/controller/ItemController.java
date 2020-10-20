package com.taotao.portalweb.controller;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.bean.TbItemDesc;
import com.taotao.portalweb.service.TbItemDescService;
import com.taotao.portalweb.service.TbItemParamService;
import com.taotao.portalweb.service.TbItemService;
import com.taotao.portalweb.vo.TbItemGroupResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController  {
    @Autowired
    private TbItemService tbItemService;
    @Autowired
    private TbItemDescService tbItemDescService;
    @Autowired
    private TbItemParamService tbItemParamService;

    @RequestMapping("/{id}")
    public String showItem(@PathVariable Long id, Model model){
        TbItem tbItem = tbItemService.findTbItemById(id);
        model.addAttribute("tbItem",tbItem);
        String image = tbItem.getImage();
        String[] split = image.split(",");
        int index = 0;
        String[] arr = new String[split.length];
        for (String s:split) {
            s.replace("\\s","");
            s.replace("\n","");
            arr[index] = s;
            index++;
        }
        model.addAttribute("image",arr);
        List<String> itemCatList = tbItemService.findTbItemCats(tbItem);
        Collections.reverse(itemCatList);
        itemCatList.add(tbItem.getTitle());
        model.addAttribute("itemCatList",itemCatList);
        return "item";
    }
    @RequestMapping("/queryItemDesc")
    @ResponseBody
    public String showItemCat(Long id){
        TbItemDesc tbItemDesc = tbItemDescService.findItemById(id);
        return tbItemDesc.getItemDesc();
    }
    @RequestMapping("/queryItemParam")
    @ResponseBody
    public List<TbItemGroupResult> showItemParam(Long id){
        List<TbItemGroupResult> results = tbItemParamService.findItemById(id);

        return results;
    }
}
