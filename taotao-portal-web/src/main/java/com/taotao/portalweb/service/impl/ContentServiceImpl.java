package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbContent;
import com.taotao.portalweb.mapper.ContentMapper;
import com.taotao.portalweb.service.ContentService;
import com.taotao.portalweb.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public TaotaoResult findContentByCId(Long categoryId) {
        List<TbContent> tbContentList = contentMapper.findContentByCId(categoryId);
        if(tbContentList.size() == 0){
            return TaotaoResult.build(500,"没有该内容");
        }

        return TaotaoResult.build(200,"",tbContentList);
    }
}
