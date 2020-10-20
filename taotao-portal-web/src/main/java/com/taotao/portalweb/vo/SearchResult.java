package com.taotao.portalweb.vo;

import com.taotao.portalweb.bean.TbItem;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{
    //用于页面显示 或者再次分页搜索的内容
    private String q;
    private List<TbItem> tbItemList;
    private Integer count;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public List<TbItem> getTbItemList() {
        return tbItemList;
    }

    public void setTbItemList(List<TbItem> tbItemList) {
        this.tbItemList = tbItemList;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "q='" + q + '\'' +
                ", tbItemList=" + tbItemList +
                ", count=" + count +
                '}';
    }
}
