package com.taotao.portalweb.vo;

import java.io.Serializable;

public class Cart implements Serializable{
    private Long id;
    private Integer num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", num=" + num +
                '}';
    }
}
