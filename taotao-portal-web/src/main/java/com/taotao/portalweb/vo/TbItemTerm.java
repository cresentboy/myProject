package com.taotao.portalweb.vo;

import java.io.Serializable;

public class TbItemTerm implements Serializable{
    private Integer groupId;
    private String groupName;
    private String termName;
    private String termValue;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermValue() {
        return termValue;
    }

    public void setTermValue(String termValue) {
        this.termValue = termValue;
    }

    @Override
    public String toString() {
        return "TbItemTerm{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", termName='" + termName + '\'' +
                ", termValue='" + termValue + '\'' +
                '}';
    }
}
