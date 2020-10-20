package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.constant.ContentConstant;
import com.taotao.portalweb.mapper.TbItemMapper;
import com.taotao.portalweb.service.SearchService;
import com.taotao.portalweb.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public SearchResult query(String q, Integer currentPage) {
        //根据当前页搜索商品列表信息
        List<TbItem> tbItemList = tbItemMapper.query(q,(currentPage-1)* ContentConstant.LIMIT,ContentConstant.LIMIT);
        for (TbItem tbitem:tbItemList) {
            String image = tbitem.getImage();
            tbitem.setImage(image.split(",")[0]);
            Long price = tbitem.getPrice();
            long integer = price / 100;
            long decimal = price % 100;
            String decimalValue = decimal==0?"00":String.valueOf(decimal);
            tbitem.setBarcode("￥："+integer+"."+decimalValue);
        }
        int count = tbItemMapper.getCount(q);
        SearchResult result = new SearchResult();
        result.setQ(q);
        result.setCount(count);
        result.setTbItemList(tbItemList);

        return result;
    }

//    @Override
//    public Map<String, Object> query(String q,Integer page) {
//        List<TbItem> tbItemList = tbItemMapper.query(q,(page-1)* ContentConstant.LIMIT,ContentConstant.LIMIT);
//        int count = tbItemMapper.getCount(q);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("queryName",q);
//        for (TbItem tbitem:tbItemList) {
//            String image = tbitem.getImage();
//            tbitem.setImage(image.split(",")[0]);
//            Long price = tbitem.getPrice();
//            long integer = price / 100;
//            long decimal = price % 100;
//            String decimalValue = decimal==0?"00":String.valueOf(decimal);
//            tbitem.setBarcode("￥："+integer+"."+decimalValue);
//        }
//
//        map.put("queryList",tbItemList);
//        map.put("queryCount",count);
//        return map;
//    }
}
