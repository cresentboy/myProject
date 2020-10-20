package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbItemCat;
import com.taotao.portalweb.bean.TbItemDesc;
import com.taotao.portalweb.mapper.TbItemCatMapper;
import com.taotao.portalweb.mapper.TbItemDescMapper;
import com.taotao.portalweb.service.TbItemCatService;
import com.taotao.portalweb.vo.ClassThree;
import com.taotao.portalweb.vo.ItemCatNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public List<ItemCatNode> findItemCatById(Long id) {
        List<ItemCatNode> nodes = new ArrayList<ItemCatNode>();
        List<TbItemCat> tbItemCatList = tbItemCatMapper.findTbItemCatById(id);
        for (TbItemCat itemCat:tbItemCatList) {
            ItemCatNode node = new ItemCatNode();
            node.setName(itemCat.getName());
            List<ClassThree> threes = new ArrayList<ClassThree>();
            List<TbItemCat> three = tbItemCatMapper.findTbItemCatById(itemCat.getId());
            for (TbItemCat cat:three) {
                ClassThree classThree = new ClassThree();
                classThree.setName(cat.getName());
                threes.add(classThree);
            }
            node.setClassThrees(threes);
            nodes.add(node);
        }
        return nodes;
    }




}
