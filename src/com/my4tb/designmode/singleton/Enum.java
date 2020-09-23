package com.my4tb.designmode.singleton;

/**
 * enum在反编译后，本例中的INSTANCE被转换为 public static final Enum INSTANCE，类加载机制保证了该实例初始化的线程安全。
 *
 * 另外，在序列化时，枚举类只是将实例名称输出，而非将实例输出。在反序列化时，是根据valueOf()方法，通过名字查找枚举对象。
 */
public enum Enum {

    INSTANCE;

    public void doSth() {
        System.out.println("~~~");
    }

    public static void main(String[] args) {
        Enum.INSTANCE.doSth();
        System.out.println(Enum.INSTANCE.ordinal());
    }

}
