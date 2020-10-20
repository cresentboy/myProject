package com.taotao.portalweb.service;

import com.taotao.portalweb.vo.SearchResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
public interface SearchService {
    /**
     * 根据内容搜索商品列表 分页显示商品信息
     * @param q 需要搜的商品内容
     * @param currentPage 当前页
     * @return
     */
    SearchResult query(String q, Integer currentPage);
}
