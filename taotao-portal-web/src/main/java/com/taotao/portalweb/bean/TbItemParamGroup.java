package com.taotao.portalweb.bean;

import java.io.Serializable;
import java.util.List;

public class TbItemParamGroup implements Serializable {
	//组id
	private Integer id;
	//组名称
	private String groupName;
	//商品分类id
	private Long itemCatId;
	//商品项
	private List<TbItemParamKey> paramKeys;
	
	public List<TbItemParamKey> getParamKeys() {
		return paramKeys;
	}
	public void setParamKeys(List<TbItemParamKey> paramKeys) {
		this.paramKeys = paramKeys;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Long getItemCatId() {
		return itemCatId;
	}
	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
	}
	@Override
	public String toString() {
		return "TbItemParamGroup [id=" + id + ", groupName=" + groupName + ", itemCatId=" + itemCatId + "]";
	}
	
}
