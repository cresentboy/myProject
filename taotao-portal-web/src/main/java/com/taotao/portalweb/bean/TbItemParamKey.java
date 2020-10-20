package com.taotao.portalweb.bean;

import java.io.Serializable;
//规格参数项对象 关联 规格参数组 还关联规格参数值
public class TbItemParamKey implements Serializable {
	//项id
	private Integer id;
	//项名称
	private String paramName;
	//项所述组id
	private Integer groupId;
	// 一对一
	private TbItemParamGroup paramGroup;

	public TbItemParamGroup getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(TbItemParamGroup paramGroup) {
		this.paramGroup = paramGroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "TbItemParamKey{" +
				"id=" + id +
				", paramName='" + paramName + '\'' +
				", groupId=" + groupId +
				'}';
	}
}
