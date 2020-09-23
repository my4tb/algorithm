package com.my4tb.designmode.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        BusinessAgentDynamicProxy businessAgentDynamicProxy = new BusinessAgentDynamicProxy(new Vendor());

        Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, businessAgentDynamicProxy);

        sell.sell();

    }

}
