package com.cheng.unittest.bean;

/**
 * @author : chengyue
 * @date : 2019/6/12 13:55
 * @history : change on 2019/6/12 13:55 by chengyue
 * @since : v
 */
public class Home {

    private Person mPerson;
    private String master;

    public  Home(Person mPerson) {
        this.mPerson = mPerson;
    }

    public String getMaster() {
        return mPerson.getName();
    }
}
