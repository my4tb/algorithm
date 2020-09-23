package com.my4tb.designmode.singleton;

/**
 * 静态内部类维护实例，第一次调用时才进行静态内部类的加载，并返回实例。
 * 这样也是通过类加载机制保证了线程安全。
 */
public class StaticInnerClass {

    private StaticInnerClass() {}

    public StaticInnerClass getInstance() {
        return InstanceHolder.instance;
    }

    private static class InstanceHolder {
        private static StaticInnerClass instance = new StaticInnerClass();
    }

}
