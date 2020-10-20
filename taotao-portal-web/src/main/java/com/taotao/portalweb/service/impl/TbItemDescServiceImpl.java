package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbItemDesc;
import com.taotao.portalweb.mapper.TbItemDescMapper;
import com.taotao.portalweb.service.TbItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbItemDescServiceImpl implements TbItemDescService {
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Override
    public TbItemDesc findItemById(Long id) {
        TbItemDesc tbItemDesc = tbItemDescMapper.findItemById(id);
        return tbItemDesc;
    }
}
