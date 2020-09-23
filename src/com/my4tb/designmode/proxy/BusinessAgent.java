package com.my4tb.designmode.proxy;

public class BusinessAgent implements Sell {

    private Vendor vendor;

    public BusinessAgent(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public void sell() {
        System.out.println("proxy doSth");
        vendor.sell();;
        System.out.println("proxy doSth");
    }

    @Override
    public void ad() {

    }
}
