package com.taotao.portalweb.vo;

import java.io.Serializable;
import java.util.List;

public class ItemCatNode implements Serializable{
    private String name;
    private List<ClassThree> classThrees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassThree> getClassThrees() {
        return classThrees;
    }

    public void setClassThrees(List<ClassThree> classThrees) {
        this.classThrees = classThrees;
    }

    @Override
    public String toString() {
        return "ItemCatNode{" +
                "name='" + name + '\'' +
                ", classThrees=" + classThrees +
                '}';
    }
}
