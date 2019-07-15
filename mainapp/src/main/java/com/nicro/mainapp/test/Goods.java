package com.nicro.mainapp.test;

import java.util.Objects;

/**
 * 商品Demo
 */
public class Goods implements Cloneable {

    int selectNum;
    String name;

    public Goods() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return selectNum == goods.selectNum &&
                name.equals(goods.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectNum, name);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "selectNum=" + selectNum +
                ", name='" + name + '\'' +
                '}';
    }

    public Goods(String name, int selectNum) {
        this.selectNum = selectNum;
        this.name = name;
    }

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
