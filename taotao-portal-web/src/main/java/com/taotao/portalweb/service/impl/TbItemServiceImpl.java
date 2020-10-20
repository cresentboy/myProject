package com.taotao.portalweb.service.impl;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.bean.TbItemCat;
import com.taotao.portalweb.mapper.TbItemCatMapper;
import com.taotao.portalweb.mapper.TbItemMapper;
import com.taotao.portalweb.service.TbItemService;
import com.taotao.portalweb.vo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public TbItem findTbItemById(Long id) {
        TbItem tbItem = tbItemMapper.findTbItemById(id);
        Long price = tbItem.getPrice();
        long integer = price / 100;
        long decimal = price % 100;
        String d = decimal == 0?"00": decimal+"";
        tbItem.setBarcode(integer+"."+d);

        return tbItem;
    }

    @Override
    public List<String> findTbItemCats(TbItem tbItem) {
        List<String> list = new ArrayList<String>();
        List<String> itemCatList = recursionTbItemCat(tbItem.getcId(),list);
        return itemCatList;
    }

    @Override
    public List<TbItem> findTbItems(List<Cart> carts) {
        List<TbItem> tbItems = new ArrayList<TbItem>();
        for (int i = 0; i < carts.size(); i++) {
            Cart cart = carts.get(i);
            TbItem item = tbItemMapper.findTbItemById(cart.getId());
            //页面传递过来的num才是真正的数据
            item.setNum(cart.getNum());
            //价格我们不用处理了 放到 页面来处理
            //数据库里面的价格 是乘以 100的
            String image = item.getImage();
            item.setImage(image.split(",")[0]);
            tbItems.add(item);
        }
      


        return tbItems;
    }

    private List<String> recursionTbItemCat(Long id,List<String> list){
        TbItemCat tbItemCat = tbItemCatMapper.getTbItemCatById(id);
        if(tbItemCat!=null){
            list.add(tbItemCat.getName());
            recursionTbItemCat(tbItemCat.getParentId(),list);
        }
        return list;
    }
}
