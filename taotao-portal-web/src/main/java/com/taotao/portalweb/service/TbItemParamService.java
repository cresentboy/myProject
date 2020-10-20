package com.taotao.portalweb.service;

import com.taotao.portalweb.vo.TbItemGroupResult;

import java.util.List;

public interface TbItemParamService {
    /**
     * 根据商品id查询商品规格参数组对象与每一组对应的规格参数项集合对象
     * @param id
     * @return
     */
    List<TbItemGroupResult> findItemById(Long id);
}
