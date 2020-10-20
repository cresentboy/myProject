package com.taotao.portalweb.service;

import com.taotao.portalweb.utils.TaotaoResult;

public interface ContentService {
    /**
     * 根据内容分类id查询内容信息
     * @param categoryId
     * @return
     */
    TaotaoResult findContentByCId(Long categoryId);
}
