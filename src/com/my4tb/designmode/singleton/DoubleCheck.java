package com.my4tb.designmode.singleton;

/**
 * 对象初始化过程：
 * 1、分配内存空间
 * 2、初始化
 * 3、将对象指向内存地址
 * 对象初始化时，如果不使用volatile关键字，会存在2、3步骤重排序，
 * 如果某个线程执行完步骤3，引用不为null，这时其它线程来获取实例，
 * 就有可能获取到未完成初始化的实例对象。
 */
public class DoubleCheck {

    private static volatile DoubleCheck instance;

    private DoubleCheck() {}

    public DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null)
                    instance = new DoubleCheck();
            }
        }
        return instance;
    }

}
