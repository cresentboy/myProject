package com.taotao.portalweb.vo;

import java.io.Serializable;

public class ClassThree implements Serializable{
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassThree{" +
                "name='" + name + '\'' +
                '}';
    }
}
