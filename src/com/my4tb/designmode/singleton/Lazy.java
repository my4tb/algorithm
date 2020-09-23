package com.my4tb.designmode.singleton;

/**
 * 第一次使用时初始化，节约了内存空间，但是synchronized关键字却增加了开销
 */
public class Lazy {

    private static Lazy singleton;

    private Lazy() {}

    public static synchronized Lazy getInstance() {
        if (singleton == null)
            singleton = new Lazy();
        return singleton;
    }

}
