package com.taotao.portalweb.service;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.vo.Cart;

import java.util.List;

public interface TbItemService {
    /**
     * 根据商品id 查询商品基本信息
     * @param id 商品id
     * @return
     */
    TbItem findTbItemById(Long id);

    /**
     * 根据商品id查询该商品所有分类名称
     * @param tbItem
     * @return
     */
    List<String> findTbItemCats(TbItem tbItem);

    /**
     * 根据商品id查询商品集合对象
     * @param carts
     * @return
     */
    List<TbItem> findTbItems(List<Cart> carts);
}
