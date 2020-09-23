package com.my4tb.designmode.singleton;

/**
 * 类加载时完成初始化，导致类加载较慢，但是避免了线程安全问题，获取对象速度较快。
 */
public class Hunger {

    /*
        类变量会在类加载的类初始化阶段初始化。
     */
    private static Hunger singleton = new Hunger();

    private Hunger() {}

    public static Hunger getInstance() {
        return singleton;
    }

}
