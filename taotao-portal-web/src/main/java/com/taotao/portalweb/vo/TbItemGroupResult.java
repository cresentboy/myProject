package com.taotao.portalweb.vo;

import java.io.Serializable;
import java.util.List;

public class TbItemGroupResult implements Serializable{
    //组id
    private Long id;
    //组名
    private String groupName;
    //每一个组对应项集合对象
    private List<TbItemTerm> itemTermList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<TbItemTerm> getItemTermList() {
        return itemTermList;
    }

    public void setItemTermList(List<TbItemTerm> itemTermList) {
        this.itemTermList = itemTermList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TbItemGroupResult{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", itemTermList=" + itemTermList +
                '}';
    }
}
