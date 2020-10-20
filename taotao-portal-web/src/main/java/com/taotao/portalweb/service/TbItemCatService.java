package com.taotao.portalweb.service;

import com.taotao.portalweb.vo.ItemCatNode;

import java.util.List;

public interface TbItemCatService {
    List<ItemCatNode> findItemCatById(Long id);
}
