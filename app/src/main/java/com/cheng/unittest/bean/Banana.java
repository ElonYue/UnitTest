package com.cheng.unittest.bean;

/**
 * @author : chengyue
 * @date : 2019/6/12 10:58
 */
public class Banana extends Fruit {

    private String bananaInfo;
    boolean isLike = true;

    public boolean isLike() {
        return isLike;
    }

    public String getBananaInfo() {
        return flavor() + COLOR;
    }

    private String flavor() {
        return "甜甜的";
    }

    private static final String COLOR = "黄色的";

    public static String color() {
        return COLOR;
    }

}
