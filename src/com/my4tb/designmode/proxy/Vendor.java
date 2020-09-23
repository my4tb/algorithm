package com.my4tb.designmode.proxy;

public class Vendor implements Sell {
    @Override
    public void sell() {
        System.out.println("vendor sell");
    }

    @Override
    public void ad() {
        System.out.println("vendor ad");
    }
}
