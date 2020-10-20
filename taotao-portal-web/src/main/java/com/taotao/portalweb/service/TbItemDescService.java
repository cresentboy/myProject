package com.taotao.portalweb.service;

import com.taotao.portalweb.bean.TbItemDesc;

public interface TbItemDescService {

    /**
     * 根据商品id查询商品描述信息
     * @param id 商品id
     * @return
     */
    TbItemDesc findItemById(Long id);
}
